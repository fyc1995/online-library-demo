package com.example.m2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/user_dashboard.html").setViewName("user_dashboard");
        registry.addViewController("/admin_dashboard.html").setViewName("admin_dashboard");
        registry.addViewController("/index.html").setViewName("index");

    }
    //自定义的国际化组件生效
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
