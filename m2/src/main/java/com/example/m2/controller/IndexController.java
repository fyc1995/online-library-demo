package com.example.m2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/","/login.html"})
    public String login(){
        System.out.println("进入login controller");
        return "login";
    }
//    @RequestMapping("/main")
//    public String userDashBoard(){
//    System.out.println("进入用户首页");
//        return "redirect:/main.html";
//    }
}
