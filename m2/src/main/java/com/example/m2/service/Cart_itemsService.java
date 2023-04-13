package com.example.m2.service;


import com.example.m2.pojo.cart_items;
import com.example.m2.pojo.order_items;

import java.util.List;

public interface Cart_itemsService {

    cart_items queryItemById(int id);
    int addItem(cart_items item);
    int deleteItemById(int id);
    List<cart_items> queryItemListByCartID(int cart_id);

}
