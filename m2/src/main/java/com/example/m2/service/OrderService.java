package com.example.m2.service;

import com.example.m2.pojo.Books;
import com.example.m2.pojo.Order;

import java.util.List;

public interface OrderService {

    //添加订单
    int addOrder(Order order);
    //取消订单
    int deleteOrderByNo(String id);

    List<Order> queryAllOrders();
    //根据用户id查询订单
    List<Order> queryOrdersByUserId(int user_id);
}
