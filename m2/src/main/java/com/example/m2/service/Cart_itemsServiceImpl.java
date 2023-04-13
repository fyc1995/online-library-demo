package com.example.m2.service;

import com.example.m2.dao.Cart_itemsMapper;
import com.example.m2.pojo.cart_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Cart_itemsServiceImpl implements Cart_itemsService{
    @Autowired
    private Cart_itemsMapper cart_itemsMapper;



    @Override
    public cart_items queryItemById(int id) {
        return cart_itemsMapper.queryItemById(id);
    }

    @Override
    public int addItem(cart_items item) {
        return cart_itemsMapper.addItem(item);
    }

    @Override
    public int deleteItemById(int id) {
        return cart_itemsMapper.deleteItemById(id);
    }

    @Override
    public List<cart_items> queryItemListByCartID(int cart_no) {
        return cart_itemsMapper.queryItemListByCartID(cart_no);
    }
}
