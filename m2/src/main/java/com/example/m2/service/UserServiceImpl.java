package com.example.m2.service;

import com.example.m2.dao.UserMapper;
import com.example.m2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    public User userLogin(String username, String password) {
        return userMapper.Login(username,password);
    }

    @Override
    public User check(String username) {
        return userMapper.check(username);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

}
