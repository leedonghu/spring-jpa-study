package com.jpa.study.springjpastudy.entity.ch7;

import java.io.Serializable;

public class GrandChildId implements Serializable{
    
    private ChildId child; //GrandChild.child 매핑
    private String id;     //GrandChild.id 매핑

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