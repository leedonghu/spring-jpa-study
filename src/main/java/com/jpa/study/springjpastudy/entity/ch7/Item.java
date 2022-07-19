package com.jpa.study.springjpastudy.entity.ch7;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@Getter
public abstract class Item {
    
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;

    private int price;

    public void setId(Long id){
        this.id = id;

    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(int price){
        this.price = price;
    }
}