package com.example.m2.controller;

import com.example.m2.pojo.Admin;
import com.example.m2.pojo.Books;
import com.example.m2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    public String queryAllAdmin(Model model){
        List<Admin> adminList = adminService.queryAdminList();
        model.addAttribute("adminList", adminList);
        return "";
    }

}
