package com.project.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component
public class Dev {
    @Autowired // field injection
    @Qualifier("desktop")
    private Computer comp;   
     
    // Dev(Laptop laptop){ // constructor injection
    //     this.laptop = laptop;
    // }   


    // public void setLaptop(Laptop laptop){ // setter injection
    //     this.laptop = laptop;
    // }

    // by default this points to null

    public Dev() {
        System.out.println("Dev is default constructor is called");
    }

    public void build(){
        comp.compile();
        System.out.println("Building the project...");
    }
}
