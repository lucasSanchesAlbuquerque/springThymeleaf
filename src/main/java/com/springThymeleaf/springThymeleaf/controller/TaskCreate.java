package com.springThymeleaf.springThymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TaskCreate {

    @GetMapping("/create")
    public String create(){
        return "create";
    }
}
