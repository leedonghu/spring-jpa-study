package com.jpa.study.springjpastudy.entity.ch7;

import java.io.Serializable;

public class ParentId implements Serializable {
    private String id1; //Parent.id1 매핑
    private String id2; //Parent.id2 매핑

    public ParentId(){

    }
    public ParentId(String id1, String id2){
        this.id1 = id1;
        this.id2 = id2;
    }

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