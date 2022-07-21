package com.jpa.study.springjpastudy.entity.ch8;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Team8 {
    
    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;
}