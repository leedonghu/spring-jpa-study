package com.jpa.study.springjpastudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity //클래스를 테이블과 매핑한다고 JPA에 알려줌
@Table(name = "MEMBER") //매핑할 테이블 정보를 알려줌
@Getter
@Setter
public class Member {
    
    @Id //PK에 매핑
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME") //필드를 컬럼에 매핑
    private String username;

    //필드명을 사용해서 칼럼명으로 매핑
    private int age;
}