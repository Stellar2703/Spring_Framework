package com.example.simpleWebApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.simpleWebApplication.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class MainController {

    @Autowired
    MainService service;

    @GetMapping("/") 
    public String forntend(){
        return service.homepage();
    }
}
