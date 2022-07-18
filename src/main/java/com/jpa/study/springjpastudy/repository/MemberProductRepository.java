package com.jpa.study.springjpastudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.study.springjpastudy.entity.Member;
import com.jpa.study.springjpastudy.entity.MemberProduct;

public interface MemberProductRepository extends JpaRepository<MemberProduct, Member> {
    
}