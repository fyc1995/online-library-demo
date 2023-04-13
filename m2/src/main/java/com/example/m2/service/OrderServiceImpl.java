package com.example.m2.service;

import com.example.m2.dao.BookMapper;
import com.example.m2.dao.OrderMapper;
import com.example.m2.pojo.Books;
import com.example.m2.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public int deleteOrderByNo(String order_no) {
        return orderMapper.deleteOrderByNo(order_no);
    }

    @Override
    public List<Order> queryAllOrders() {
        return orderMapper.queryAllOrders();
    }

    @Override
    public List<Order> queryOrdersByUserId(int user_id) {
        return orderMapper.queryOrdersByUserId(user_id);
    }
}
