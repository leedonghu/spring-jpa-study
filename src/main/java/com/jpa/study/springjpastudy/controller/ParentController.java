package com.jpa.study.springjpastudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.study.springjpastudy.service.ParentService;


@RestController
@RequestMapping("/par")
public class ParentController {
    
    @Autowired
    private ParentService ps;

    @GetMapping("/save")
    public void save(){
        ps.save();
    }

    @GetMapping("/get")
    public void get(){
        ps.get();
    }
}