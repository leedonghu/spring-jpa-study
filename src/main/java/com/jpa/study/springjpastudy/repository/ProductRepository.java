package com.jpa.study.springjpastudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.study.springjpastudy.entity.ch6.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
    
}