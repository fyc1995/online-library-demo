package com.example.m2.service;

import com.example.m2.dao.BookMapper;
import com.example.m2.pojo.Books;
import com.example.m2.pojo.top5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("BookServiceImpl")
public class BookServiceImpl implements BookService{

    //service 调dao层 获取dao层对象
   @Autowired
    private BookMapper bookMapper;

    @Override
    public int addBooks(Books books) {
        return bookMapper.addBooks(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }

    @Override
    public Books queryBookName(String bookName) {
        return bookMapper.queryBookName(bookName);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }


    @Override
    public int deleteStack(int id) {
        return bookMapper.deleteStack(id);
    }

    @Override
    public int addStack(int id) {
        return bookMapper.addStack(id);
    }

    @Override
    public List<top5> queryTop5() {
        return bookMapper.queryTop5();
    }


}
