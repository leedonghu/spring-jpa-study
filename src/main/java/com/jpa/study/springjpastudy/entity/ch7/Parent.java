package com.jpa.study.springjpastudy.entity.ch7;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;

@Entity
@IdClass(ParentId.class)
@Getter
@Setter
public class Parent {
    
    @Id
    @Column(name = "PARENT_ID1")
    private String id1; //ParentId.id1과 연결

    @Id
    @Column(name = "PARENT_ID2")
    private String id2; //ParentId.id2와 연결

    private String name;
}