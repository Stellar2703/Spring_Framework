package com.project.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    @Autowired
    private Laptop laptop; 
    // by default this points to null
    public void build(){
        laptop.compile();
        System.out.println("Building the project...");
    }
}
