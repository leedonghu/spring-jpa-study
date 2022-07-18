package com.jpa.study.springjpastudy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private String id;

    private String name;

    @OneToMany(mappedBy = "product")
    private List<Order> orders = new ArrayList<>();

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
}