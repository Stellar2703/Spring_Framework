package com.project.myapp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



@Component
@Primary
public class Laptop implements Computer {

    public void compile(){
        System.out.println("Compiling the code on the Laptop...");
    }

    public void debug (){
        System.out.println("Debugging the code on the Laptop...");
    }
}
