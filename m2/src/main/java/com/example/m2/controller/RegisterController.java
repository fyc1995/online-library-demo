package com.example.m2.controller;

import com.example.m2.pojo.Cart;
import com.example.m2.pojo.User;
import com.example.m2.service.CartService;
import com.example.m2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;


@Controller
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;

    @RequestMapping("/user/register")
    public String toRegister(){
        System.out.println("进入注册controller");
        return "register";
    }
    @RequestMapping("/user/toRegister")
    public String register(User user, Model model){
        System.out.println("进入注册页面");
        User user1 = userService.check(user.getName());
        if(user1!=null){
            model.addAttribute("msg","User existed");
            return "register";
        }
        Date date = new Date();
        java.sql.Date sdate= new java.sql.Date(date.getTime());
        user.setRegisterDate(sdate);

        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String newpassword = bcryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(newpassword);
        userService.addUser(user);

        //为用户创建购物车
        int user_id = user.getId();

        Cart cart = new Cart(user_id,sdate);
        cartService.createCart(cart);

        model.addAttribute("msg","Success");
        return "redirect:/login.html";
    }


}
