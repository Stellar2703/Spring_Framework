package com.project.myapp;

import org.springframework.stereotype.Component;

@Component
public class Laptop {

    public void compile(){
        System.out.println("Compiling the code...");
    }

    public void debug (){
        System.out.println("Debugging the code...");
    }
}
