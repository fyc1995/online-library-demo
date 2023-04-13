package com.example.m2.dao;

import com.example.m2.pojo.order_items;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface order_itemsMapper {
    List<order_items> queryOrderItemList();
    order_items queryItemById(int id);
    int addItem(order_items item);
    int deleteItemById(int id);
    order_items queryItemByOrderNo(String order_no);
}
