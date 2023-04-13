package com.example.m2.dao;


import com.example.m2.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper {
        List<User> queryUserList();

        User queryUserById(int id);
        User Login(String name,String password);
        int addUser(User user);
//        int updateUser(User user);
        User check(String username);
        int deleteUserById(int id);

}
