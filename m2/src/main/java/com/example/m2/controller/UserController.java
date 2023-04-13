package com.example.m2.controller;

import com.example.m2.dao.UserMapper;
import com.example.m2.pojo.User;
import com.example.m2.service.UserService;
import com.example.m2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/users")
    public String queryUserList(Model model){
        List<User> list = userMapper.queryUserList();

        model.addAttribute("customer",list);

        return "customer/list.html";
    }

    @RequestMapping("/users/toDelete/{id}")
    public String toDeleteUser(@PathVariable("id") int id){
        System.out.println(id);
        userMapper.deleteUserById(id);
        return "redirect:/users";
    }
    @RequestMapping("/touserprofile")
    public String queryUsertoProfile(Model model){
        System.out.println("userprofilepage");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userService.check(username);
        model.addAttribute("user",user);
        System.out.println(user);
        return "userprofile";
    }
}
