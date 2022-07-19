package com.jpa.study.springjpastudy.entity.ch6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;

@Entity
@Getter
public class Locker {
    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;

    public void setId(Long id){
        this.id = id;

    }

    public void setName(String name){
        this.name = name;
    }
}