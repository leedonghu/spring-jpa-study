package com.jpa.study.springjpastudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "TEAM") 
@Getter
@Setter
public class Team {
    
    @Id
    @Column(name = "TEAM_ID")
    private String tid;

    private String name;

    public Team(){

    }

    public Team(String tid, String name){
        this.tid = tid;
        this.name = name;
    }
}