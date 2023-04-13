package com.example.m2.service;

import com.example.m2.pojo.Books;
import com.example.m2.pojo.order_items;
import com.example.m2.pojo.top5;

import java.util.List;
public interface BookService {

    //增加一本书

    int addBooks(Books books);
    //删除一本书
    int deleteBookById(int id);
    //修改一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBookById(int id);
    //查询全部书
    List<Books> queryAllBooks();

    Books queryBookName(String bookName);

    int deleteStack(int id);

    int addStack(int id);

    List<top5> queryTop5();
}
