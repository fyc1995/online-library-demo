package com.example.m2.service;

import com.example.m2.dao.CartMapper;
import com.example.m2.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Override
    public int createCart(Cart cart) {
        return cartMapper.createCart(cart);
    }

    @Override
    public Cart queryCartByUserId(int user_id) {
        //一个用户一个购物车
        return cartMapper.queryCartByUserId(user_id);
    }
}
