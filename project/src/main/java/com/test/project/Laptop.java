package com.test.project;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // having same type
public class Laptop implements Computer {

    public void compile(){
        System.out.println("in laptop");
    }
}
