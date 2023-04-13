package com.example.m2.service;


import com.example.m2.pojo.order_items;

import java.util.List;

public interface order_itemsService {
    order_items queryItemById(int id);
    int addItem(order_items item);
    int deleteItemById(int id);
    order_items queryItemByOrderNo(String order_no);
}
