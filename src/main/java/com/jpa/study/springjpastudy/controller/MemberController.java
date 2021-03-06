package com.jpa.study.springjpastudy.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.study.springjpastudy.entity.ch6.Member;
// import com.jpa.study.springjpastudy.entity.Team;
import com.jpa.study.springjpastudy.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
    
    @Autowired
    MemberService memberService;

    @GetMapping("/test/eager/save")
    public void eagerSave(){
        memberService.eagerSave();
    }
    @GetMapping("/test/eager")
    public void eager(){
        memberService.eager();
    }
    @GetMapping("/test/connect")
    public void connect(){
        memberService.connetEntity();
    }
    @GetMapping("/test/many")
    public void many(){
        memberService.ManyToMany();
    }

    @GetMapping("/test/many/find")
    public void manyFind(){
        memberService.manyFind();;
    }

    @GetMapping("/test/oneToMany")
    public void oneToMany(){
        memberService.oneToMany();
    }

    @GetMapping("/test/bi")
    public void biDirection(){
        memberService.biDirection();
    }

    @GetMapping(value = "/test/delete/team")
    public void deleteTeam(){
        memberService.deleteTeam();
    }
    @GetMapping(value = "/test/delete")
    public void deleteRelation(){
        memberService.deleteRelation();
    }

    @GetMapping(value = "/test/update")
    public void updateRelation(){
        memberService.updateRelation();
    }
     // ?????? ?????? ??????
     @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
     public ResponseEntity<List<Member>> getAllmembers() {
         List<Member> member = memberService.findAll();
         return new ResponseEntity<List<Member>>(member, HttpStatus.OK);
     }
 
     // ??????????????? ????????? ?????? ??????
     @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
     public ResponseEntity<Member> getMember(@PathVariable("id") Long id) {
         Optional<Member> member = memberService.findById(id);
         return new ResponseEntity<Member>(member.get(), HttpStatus.OK);
     }

     //?????????????????? ?????? ??????
     @GetMapping(value = "/name/{username}", produces = { MediaType.APPLICATION_JSON_VALUE })
     public ResponseEntity<Member> getMemberByUsername(@PathVariable("username") String username) {
         Optional<Member> member = memberService.findByUsername(username);
         return new ResponseEntity<Member>(member.get(), HttpStatus.OK);
     }
 
     // ??????????????? ?????? ??????
     @DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
     public ResponseEntity<Void> deleteMember(@PathVariable("id") Long id) {
         memberService.deleteById(id);
         return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
     }
 
     // ??????????????? ?????? ??????(mbrNo??? ????????? ?????? Member ????????? id, name??? ?????????)
     @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
     public ResponseEntity<Member> updateMember(@PathVariable("id") Long id, Member member) {
         memberService.updateById(id, member);
         return new ResponseEntity<Member>(member, HttpStatus.OK);
     }
 
     // ?????? ??????
     @PostMapping
     public ResponseEntity<Member> save(Member member) {
         return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
     }
 
     // ?????? ??????
     @RequestMapping(value="/saveMember", method = RequestMethod.GET)
     public ResponseEntity<Member> save(HttpServletRequest req, Member member){
         return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
     }

     @GetMapping(value = "/test/save")
     public String testSave(){
        memberService.testSave();
        return "success";
     }

     @GetMapping(value = "/test/search")
     public void testSearch(){
        // memberService.queryLogicJoin();
     }



     @GetMapping("/test")
     public String test(){
        return "test";
     }
 
}