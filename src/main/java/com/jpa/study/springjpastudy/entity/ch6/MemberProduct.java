package com.jpa.study.springjpastudy.entity.ch6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;

@Entity
@IdClass(MemberProductId.class)
@Table(name = "MEMBER_PRODUCT")
@Getter
public class MemberProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Id
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