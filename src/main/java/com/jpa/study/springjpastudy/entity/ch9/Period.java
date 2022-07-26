package com.jpa.study.springjpastudy.entity.ch9;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Period {
    @Temporal(TemporalType.DATE)
    java.util.Date startDate;
    @Temporal(TemporalType.DATE)
    java.util.Date endDate;

    public boolean isWork(Date date){
        // ... 값 타입을 위한 메소드를 정의할 수 있음
        return false;
    }
}