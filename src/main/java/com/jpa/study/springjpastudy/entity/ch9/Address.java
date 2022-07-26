package com.jpa.study.springjpastudy.entity.ch9;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Embeddable
public class Address implements Cloneable {
    @Column(name = "city") //매핑할 컬럼 정의 가능
    private String city;
    private String street;
    private String zipcode;
    
    public Address(){

    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        Address a = (Address) obj;

        return this.city.equals(a.city) && this.street.equals(a.street) && this.zipcode.equals(a.zipcode) ? true : false;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}