package com.jpa.study.springjpastudy.entity.ch7;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}