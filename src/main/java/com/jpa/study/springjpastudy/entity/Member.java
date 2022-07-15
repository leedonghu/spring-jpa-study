package com.jpa.study.springjpastudy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity //클래스를 테이블과 매핑한다고 JPA에 알려줌
@Table(name = "MEMBER") //매핑할 테이블 정보를 알려줌
@Getter
@Setter
public class Member {
    
    @Id //PK에 매핑
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME") //필드를 컬럼에 매핑
    private String username;

    //연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    //필드명을 사용해서 칼럼명으로 매핑
    private int age;

    @Enumerated(EnumType.STRING) //enum 타입 사용
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) //날짜 타입 매핑
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifedDate;

    @Lob //필드의 길이제한이 없음, VARCHAR타입 대신에 CLOB타입으로 저장
    private String description;
}


