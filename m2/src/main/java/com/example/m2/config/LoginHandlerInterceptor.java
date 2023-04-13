package com.example.m2.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后，应该有用户的session；
        Object user = request.getSession().getAttribute("user");
        if(user == null){
            request.setAttribute("msg","No permission， Please Sign in");
            request.getRequestDispatcher("/index.html").forward(request,response);
//            request.getRequestDispatcher("/register.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
