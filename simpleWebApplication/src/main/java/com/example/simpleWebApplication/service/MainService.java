package com.example.simpleWebApplication.service;

import org.springframework.stereotype.Service;

@Service
public class MainService {

    public String homepage(){
        return "welcome to the homepage";
    }
}
