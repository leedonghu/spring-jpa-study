package com.jpa.study.springjpastudy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.study.springjpastudy.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public Optional<Member> findById(Long id);

    public Optional<Member> findByUsername(String username);

    @Query("select m from Member m join m.team t where t.name = :teamName")
    public List<Member> findByTeamName(@Param("teamName") String teamName);

    public List<Member> findAll();
}