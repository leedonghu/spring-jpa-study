package com.jpa.study.springjpastudy.entity.ch7;

import java.io.Serializable;

public class ChildId implements Serializable{
    
    private String parent; //Child.parent 매핑
    private String ChildId; //Child.childId 매핑

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