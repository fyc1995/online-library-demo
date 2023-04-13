package com.example.m2.dao;

import com.example.m2.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
    List<Admin> queryAdminList();
    Admin queryAdminById(int id);
    Admin admin_Login(String username,String password);
    int addAdmin(Admin admin);
     int updateAdmin(Admin admin);
    Admin checkAdmin(String username);
    int deleteAdminById(int id);
}
