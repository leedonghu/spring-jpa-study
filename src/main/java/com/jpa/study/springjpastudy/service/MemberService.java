package com.jpa.study.springjpastudy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.study.springjpastudy.entity.ch6.Member;
import com.jpa.study.springjpastudy.entity.ch6.Order;
import com.jpa.study.springjpastudy.entity.ch6.Product;
import com.jpa.study.springjpastudy.entity.ch6.Team;
import com.jpa.study.springjpastudy.entity.ch8.Member8;
import com.jpa.study.springjpastudy.entity.ch8.Team8;

import com.jpa.study.springjpastudy.repository.MemberRepository;
import com.jpa.study.springjpastudy.repository.OrderRepository;
import com.jpa.study.springjpastudy.repository.ProductRepository;
import com.jpa.study.springjpastudy.repository.TeamRepository;

@Service
public class MemberService {
    @Autowired
    private EntityManagerFactory ef;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ProductRepository productRepository;

    

    @Autowired
    private OrderRepository orderRepository;
    
    public void eagerSave(){
        EntityManager em = ef.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Team8 team = new Team8();
        team.setId("team1");
        team.setName("team1");
        em.persist(team);
        Member8 member = new Member8();
        member.setId("member1");
        member.setUsername("lee");
        member.setTeam(team);
        em.persist(member);
        et.commit();
        
        em.close();

    }

    public void eager(){
        EntityManager em = ef.createEntityManager();
        Member8 member = em.find(Member8.class, "member1");
        Team8 team = member.getTeam();
        System.out.println(team.getName());
    }

    @Transactional
    public void connetEntity(){
        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        productRepository.save(productA);

        Member member1 = new Member();
        member1.setUsername("회원1");
        
        memberRepository.save(member1);

        Order order = new Order();
        order.setOrderAmount(2);
        order.setMember(member1);
        order.setProduct(productA);
        orderRepository.save(order);
    }

    @Transactional
    public void ManyToMany(){
        Product productA = new Product();
        productA.setId("productB");
        productA.setName("상품B");
        productRepository.save(productA);

        Member member1 = new Member();
        member1.setUsername("회원2");
        member1.getProducts().add(productA);
        memberRepository.save(member1);
    }

    @Transactional
    public void manyFind(){
        Optional<Member> a = memberRepository.findByUsername("회원2");
        Member member = a.get();
        List<Product> products = member.getProducts(); //객체 그래프 탐색
        for(Product product : products){
            System.out.println(product.getName());
        }
    }

    @Transactional
    public void oneToMany(){
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setId(1l);
        member2.setId(2l);

        Team team1 = new Team();
        team1.setTid("team1");
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        memberRepository.save(member1);
        memberRepository.save(member2);
        teamRepository.save(team1);
    }
    @Transactional
    public void biDirection(){
        Optional<Team> a = teamRepository.findById("team1");
        Team team = a.get();
        List<Member>members = team.getMembers();
        for(Member member : members){
            System.out.println(member.getUsername());
        }
    }


    public void deleteTeam(){
        Optional<Member> a = memberRepository.findById(1l);
        Optional<Member> b = memberRepository.findById(2l);

        Member member1 = a.get();
        Member member2 = b.get();

        member1.setTeam(null); //회원1 연관관계 삭제
        member2.setTeam(null); //회원2 연관관계 삭제
        memberRepository.save(member1);
        memberRepository.save(member2);

        teamRepository.deleteAllInBatch(); //팀 삭제
        //deleteAll()
        //내부에서 findAll 메서드를 호출하여 전체 데이터를 조회
        //한 건씩 delete 처리
 
    }
    public void deleteRelation(){
        Optional<Member> a = memberRepository.findById(1l);
        Member member1 = a.get();
        member1.setTeam(null);
        memberRepository.save(member1);
    }

    public Member save(Member member){
        memberRepository.save(member);
        return member;
    }
    public List<Member> findAll(){
        List<Member> members = new ArrayList<>();
        memberRepository.findAll().forEach(e -> members.add(e));
        return members;
    }

    public Optional<Member> findById(Long id){
        Optional<Member> member = memberRepository.findById(id);
        return member;
    }

    public void deleteById(Long id){
        memberRepository.deleteById(id);
    }

    public void updateById(Long id, Member member){
        Optional<Member> e = memberRepository.findById(id);

        if(e.isPresent()){
            e.get().setId(member.getId());
            e.get().setUsername(member.getUsername());
            e.get().setAge(member.getAge());
            memberRepository.save(member);
        }
    }

    public Optional<Member> findByUsername(String username){
        Optional<Member> member = memberRepository.findByUsername(username);
        return member;
    }

    public void testSave(){
        //팀1 저장
        Team team1 = new Team("team1", "팀1");
        teamRepository.save(team1);

        //회원1 저장
        Member member1 = new Member();
        member1.setId(1l);
        member1.setUsername("회원1");
        // member1.setTeam(team1);
        memberRepository.save(member1);

        //회원2 저장
        Member member2 = new Member();
        member2.setId(2l);
        member2.setUsername("회원2");
        member2.setTeam(team1);
        memberRepository.save(member2);
    }

    public void queryLogicJoin(){
        List<Member> members = memberRepository.findByTeamName("팀1");
        for(Member a : members){
            System.out.println("member.username = " + a.getUsername());
        }
        
    }

    public void updateRelation(){
        //새로운 팀2
        Team team2 = new Team("team2", "팀2");
        teamRepository.save(team2);

        //회원1에 새로운 팀2 설정
        Optional<Member> a = memberRepository.findByUsername("회원1");
        Member member = a.get();
        member.setTeam(team2);
        memberRepository.save(member);
    }
}