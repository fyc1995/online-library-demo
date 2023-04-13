package com.example.m2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UlandDlController {
    @RequestMapping("/uLAndDL")
    public String uLAndDL(){
        return "uLAndDL";
    }
}
