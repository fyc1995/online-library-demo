package com.example.m2.service;


import com.example.m2.dao.AdminMapper;
import com.example.m2.dao.UserMapper;
import com.example.m2.pojo.Admin;
import com.example.m2.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("userDetailsService")
public class SpringDataUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
   private AdminMapper adminMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);

        User user = userMapper.check(username);
        Admin admin = adminMapper.checkAdmin(username);

        try {
            if (user == null && admin ==null){
                throw new UsernameNotFoundException("用户名不存在");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        //用户权限
        List<GrantedAuthority> authorities;
        if(user==null){
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");

            System.out.println(authorities);
            return new org.springframework.security.core.userdetails.User(admin.getUsername(),new BCryptPasswordEncoder().encode(admin.getPassword()),authorities);

        }
        else {
            System.out.println("权限为user");
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("user");

            return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
//            return new org.springframework.security.core.userdetails.User(user.getName(),new BCryptPasswordEncoder().encode(user.getPassword()),authorities);
        }



//        return new org.springframework.security.core.userdetails.User(user.getName(),new BCryptPasswordEncoder().encode(user.getPassword()),authorities);

    }
}
