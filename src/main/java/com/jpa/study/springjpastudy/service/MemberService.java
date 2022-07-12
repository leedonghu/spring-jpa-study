package com.jpa.study.springjpastudy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.study.springjpastudy.entity.Member;
import com.jpa.study.springjpastudy.repository.MemberRepository;

@Service
public class MemberService {
    
    @Autowired
    private MemberRepository memberRepository;

    public Member save(Member member){
        memberRepository.save(member);
        return member;
    }
    public List<Member> findAll(){
        List<Member> members = new ArrayList<>();
        memberRepository.findAll().forEach(e -> members.add(e));
        return members;
    }

    public Optional<Member> findById(String id){
        Optional<Member> member = memberRepository.findById(id);
        return member;
    }

    public void deleteById(String id){
        memberRepository.deleteById(id);
    }

    public void updateById(String id, Member member){
        Optional<Member> e = memberRepository.findById(id);

        if(e.isPresent()){
            e.get().setId(member.getId());
            e.get().setUsername(member.getUsername());
            e.get().setAge(member.getAge());
            memberRepository.save(member);
        }
    }
}