package com.jpa.study.springjpastudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.study.springjpastudy.entity.ch6.Member;
import com.jpa.study.springjpastudy.entity.ch6.MemberProduct;

public interface MemberProductRepository extends JpaRepository<MemberProduct, Member> {
    
}