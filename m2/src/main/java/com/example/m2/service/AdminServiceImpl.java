package com.example.m2.service;

import com.example.m2.dao.AdminMapper;
import com.example.m2.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> queryAdminList() {
        return adminMapper.queryAdminList();
    }

    @Override
    public Admin queryAdminById(int id) {
        return adminMapper.queryAdminById(id);
    }

    @Override
    public Admin admin_Login(String username, String password) {
        return adminMapper.admin_Login(username, password);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public Admin checkAdmin(String username) {
        return adminMapper.checkAdmin(username);
    }

    @Override
    public int deleteAdminById(int id) {
        return adminMapper.deleteAdminById(id);
    }
}
