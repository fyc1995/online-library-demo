package com.example.m2.service;

import com.example.m2.pojo.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {
    List<Admin> queryAdminList();
    Admin queryAdminById(int id);
    Admin admin_Login(String username,String password);
    int addAdmin(Admin admin);
    int updateAdmin(Admin admin);
    Admin checkAdmin(String username);
    int deleteAdminById(int id);
}
