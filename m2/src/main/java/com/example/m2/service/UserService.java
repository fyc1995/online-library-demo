package com.example.m2.service;

import com.example.m2.pojo.User;

public interface UserService {

     User userLogin(String username, String password);
     //find user by username
     User check(String username);

     int addUser(User user);
}
