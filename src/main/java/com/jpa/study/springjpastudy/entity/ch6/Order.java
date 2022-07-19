package com.jpa.study.springjpastudy.entity.ch6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(nullable = true)
    private int orderAmount;

    public void setOrderAmount(int orderAmount){
        this.orderAmount = orderAmount;
    }

    public void setMember(Member member){
        this.member = member;
    }

    public void setProduct(Product product){
        this.product = product;
    }
}