package com.example.m2.dao;

import com.example.m2.pojo.cart_items;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Cart_itemsMapper {

    cart_items queryItemById(int id);
    int addItem(cart_items item);
    int deleteItemById(int id);
    List<cart_items> queryItemListByCartID(int cart_id);

}
