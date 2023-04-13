package com.example.m2.dao;

import com.example.m2.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper {

    //创建
    int createCart(Cart cart);

    Cart queryCartByUserId(int user_id);
}

