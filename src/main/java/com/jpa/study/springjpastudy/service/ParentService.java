package com.jpa.study.springjpastudy.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.study.springjpastudy.entity.ch7.Parent;
import com.jpa.study.springjpastudy.entity.ch7.ParentId;

@Service
public class ParentService {
    
    @Autowired
    private EntityManagerFactory ef;

    public void save(){
        EntityManager em = ef.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Parent parent1 = new Parent();
        parent1.setId1("myId1"); //식별자
        parent1.setId2("myId2"); //식별자
        parent1.setName("parentName");
        em.persist(parent1);

        Parent parent2 = new Parent();
        parent2.setId1("myId1"); //식별자
        parent2.setId2("myId2"); //식별자
        parent2.setName("parentName");
        em.persist(parent2);

        System.out.println(parent1.equals(parent2));
        et.commit();
        em.close();
    }

    public void get(){
        EntityManager em = ef.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        ParentId parentId = new ParentId("myId1", "myId2");
        Parent parent = em.find(Parent.class, parentId);
        System.out.println(parent.getName());
        
        et.commit();
        em.close();
    }
}