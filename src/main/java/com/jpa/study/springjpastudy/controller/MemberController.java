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

import com.jpa.study.springjpastudy.entity.Member;
import com.jpa.study.springjpastudy.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
    
    @Autowired
    MemberService memberService;

     // 모든 회원 조회
     @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
     public ResponseEntity<List<Member>> getAllmembers() {
         List<Member> member = memberService.findAll();
         return new ResponseEntity<List<Member>>(member, HttpStatus.OK);
     }
 
     // 회원번호로 한명의 회원 조회
     @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
     public ResponseEntity<Member> getMember(@PathVariable("id") String id) {
         Optional<Member> member = memberService.findById(id);
         return new ResponseEntity<Member>(member.get(), HttpStatus.OK);
     }
 
     // 회원번호로 회원 삭제
     @DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
     public ResponseEntity<Void> deleteMember(@PathVariable("id") String id) {
         memberService.deleteById(id);
         return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
     }
 
     // 회원번호로 회원 수정(mbrNo로 회원을 찾아 Member 객체의 id, name로 수정함)
     @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
     public ResponseEntity<Member> updateMember(@PathVariable("id") String id, Member member) {
         memberService.updateById(id, member);
         return new ResponseEntity<Member>(member, HttpStatus.OK);
     }
 
     // 회원 입력
     @PostMapping
     public ResponseEntity<Member> save(Member member) {
         return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
     }
 
     // 회원 입력
     @RequestMapping(value="/saveMember", method = RequestMethod.GET)
     public ResponseEntity<Member> save(HttpServletRequest req, Member member){
         return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
     }

     @GetMapping("/test")
     public String test(){
        return "test";
     }
 
}