package com.example.m2.service;

import com.example.m2.dao.order_itemsMapper;
import com.example.m2.pojo.Admin;
import com.example.m2.pojo.order_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class order_itemsServiceImpl implements order_itemsService{

@Autowired
   private order_itemsMapper order_itemsMapper;

    @Override
    public order_items queryItemById(int id) {
        return order_itemsMapper.queryItemById(id);
    }

    @Override
    public int addItem(order_items item) {
        return order_itemsMapper.addItem(item);
    }

    @Override
    public int deleteItemById(int id) {
        return order_itemsMapper.deleteItemById(id);
    }

    @Override
    public order_items queryItemByOrderNo(String order_no) {
        return order_itemsMapper.queryItemByOrderNo(order_no);
    }
}
