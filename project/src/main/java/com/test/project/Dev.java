package com.test.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    @Autowired // field injection
    @Qualifier("desktop")
    private Computer comp; // loose coupling

    // Constructor injection
//    public Dev(Laptop laptop){
//        this.laptop = laptop;
//    }

    // Setter Injection
//    @Autowired
//    public void setLaptop(Laptop laptop){
//        this.laptop = laptop;
//    }

    public void build(){

        comp.compile();
        System.out.println("hello world");
    }
}
