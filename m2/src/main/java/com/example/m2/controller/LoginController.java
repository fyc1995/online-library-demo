package com.example.m2.controller;

import com.example.m2.pojo.User;
import com.example.m2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
//@RequestMapping("/login")
//    public String userDashBoard(){
//    System.out.println("进入用户首页");
//        return "redirect:/main.html";
//    }
//    @RequestMapping("/user/login")
////    ??? @ResponseBody
//
//    public String login(@RequestParam("username") String username,
//                        @RequestParam("password") String  password,
//                        Model model, HttpSession session){
//        System.out.println("进入登录controller");
//        User user = userService.userLogin(username,password);
//        System.out.println(user);
//        if(user!=null){
//            session.setAttribute("user",username);
//            System.out.println("登录判断");
//           return "redirect:/main.html";
//        }else {
//            model.addAttribute("msg","username or password was wrong");
//          return "index";
//        }
//        if(!StringUtils.containsWhitespace(username)&&"123456".equals(password)){
//            session.setAttribute("user",username);
//            return "redirect:/main.html";
//        }else {
//            //登录失败
//            model.addAttribute("msg","username or password was wrong");
//            return "index";
//        }

    }

