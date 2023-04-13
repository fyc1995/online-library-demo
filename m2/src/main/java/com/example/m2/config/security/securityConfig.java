package com.example.m2.config.security;

import com.example.m2.dao.UserMapper;
import  com.example.m2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
@EnableWebSecurity
public  class securityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

//    //授权
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//            http.formLogin().loginPage("/index.html").loginProcessingUrl("/login").defaultSuccessUrl("/main");
//        http.formLogin().loginPage("/index.html").loginProcessingUrl("/login").defaultSuccessUrl("/main").and().authorizeHttpRequests().
//                antMatchers("/").permitAll().
//                antMatchers("/main").hasAnyAuthority("user");;
//        System.out.println("remember me");
//        http.rememberMe();
//    }
    //认证

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());

    }
    @Bean
    PasswordEncoder password(){return new BCryptPasswordEncoder();}
//注意这里要放在 configure(AuthenticationManagerBuilder auth) 方法下面
        //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").defaultSuccessUrl("/index.html").and().authorizeHttpRequests().
                antMatchers(
                        HttpMethod.GET,
                        "/**/*.css",
                        "/**/*.js"
                        ).permitAll().
                antMatchers("/").permitAll().
                antMatchers("/index.html").permitAll().
                antMatchers("/user_dashboard.html").hasAnyAuthority("user").
                antMatchers("/admin_dashboard.html").hasAnyAuthority("admin").and().csrf().disable()
                ;
        http.logout();
        http.rememberMe().rememberMeParameter("remember");
    }


}
