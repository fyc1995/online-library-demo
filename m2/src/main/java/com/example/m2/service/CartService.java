package com.example.m2.service;

import com.example.m2.pojo.Cart;
import com.example.m2.pojo.Order;

import java.util.List;

public interface CartService {
    //创建购物车
    int createCart(Cart cart);

    //根据用户id查询购物车内容
    Cart queryCartByUserId(int user_id);
}