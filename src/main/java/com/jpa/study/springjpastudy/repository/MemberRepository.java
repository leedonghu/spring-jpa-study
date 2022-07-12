package com.jpa.study.springjpastudy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.study.springjpastudy.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    public Optional<Member> findById(String id);

    public List<Member> findAll();
}