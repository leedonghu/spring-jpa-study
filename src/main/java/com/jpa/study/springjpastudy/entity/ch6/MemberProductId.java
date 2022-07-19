package com.jpa.study.springjpastudy.entity.ch6;

import java.io.Serializable;

public class MemberProductId implements Serializable {
    
    private Long member;
    private String product;

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}