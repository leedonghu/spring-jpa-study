package com.jpa.study.springjpastudy.entity.ch7;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID") //ID 재정의
@Getter
@Setter
public class Book extends Item {
    
    private String author;
    private String isbn;
}