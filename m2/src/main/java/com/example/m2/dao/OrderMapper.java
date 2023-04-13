package com.example.m2.dao;

import com.example.m2.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    //添加订单
    int addOrder(Order order);
    //取消订单
    int deleteOrderByNo(String order_no);

//    int updateOrder(Order order);
//    //查询一本书
//    Order queryOrderById(int id);

    List<Order> queryAllOrders();
    //根据用户id查询订单
    List<Order> queryOrdersByUserId(int user_id);
}

