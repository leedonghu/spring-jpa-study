package com.jpa.study.springjpastudy.entity.ch7;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seller extends BaseEntity {
    //id 상속
    //name 상속
    private String shopName;
}