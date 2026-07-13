package com.project.myapp;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {

    public void compile() {
        System.out.println("Compiling on Desktop...");
    }

    public void debug() {
        System.out.println("Debugging on Desktop...");
    }
}
