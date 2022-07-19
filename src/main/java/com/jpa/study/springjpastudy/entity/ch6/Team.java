package com.jpa.study.springjpastudy.entity.ch6;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
// import lombok.Setter;

@Entity 
@Table(name = "TEAM") 
@Getter

public class Team {
    
    @Id
    @Column(name = "TEAM_ID")
    private String tid;

    private String name;

    @OneToMany(mappedBy = "team")//양방향 매핑일때 반대쪽 매핑의 필드 이름 값
    // @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<>();


    public Team(){

    }

    public Team(String tid, String name){
        this.tid = tid;
        this.name = name;
    }

    public void setTid(String tid){
        this.tid = tid;
    }

    public void setName(String name){
        this.name = name;
    }
}