package com.example.m2;

import com.example.m2.dao.*;
import com.example.m2.pojo.*;
import com.example.m2.utils.RedisUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@SpringBootTest
class M2ApplicationTests {
@Autowired
    DataSource dataSource;
@Autowired
    BookMapper bookMapper;
@Autowired
    AdminMapper adminMapper;
@Autowired
    OrderMapper orderMapper;
@Autowired
    order_itemsMapper order_itemsMapper;
@Autowired
    CartMapper cartMapper;
@Autowired
    Cart_itemsMapper cart_itemsMapper;
        @Autowired
        @Qualifier("redisTemplate")
     private    RedisTemplate redisTemplate;
        @Autowired
    private RedisUtil redisUtil;
    @Test
    void contextLoads() {
//        Books books = new Books(1,"java",20,"java base");
//        bookMapper.updateBook(books);
//        System.out.println( bookMapper.queryBookName("c"));
//        Date date = new Date();
//        java.sql.Date sdate= new java.sql.Date(date.getTime());
//        String order_no = RandomStringUtils.randomAlphanumeric(10);
//        System.out.println(order_no);
//        Order order = new Order(order_no,11,1,sdate);
//        Books books = bookMapper.queryBookName("java");
//        order_items items = new order_items("kbPC7Nimeb",3,books.getBookName(),1);
//        order_itemsMapper.addItem(items);
////        bookMapper.deleteStack(3);
//            bookMapper.addStack(3);
//        orderMapper.deleteOrderByNo("FDTyH9lZ3E");
//                List<top5> list = bookMapper.queryTop5();
//            System.out.println(list);

//        System.out.println(cartMapper.queryCartByUserId(12));
//        Cart cart = cartMapper.queryCartByUserId(12);
//
//        Books book = bookMapper.queryBookName("java");
//
//        int bookID = book.getBookID();
//        int quantity = 1;
//        cart_items cart_items = new cart_items(cart.getId(),bookID,book.getBookName(),quantity);
//        cart_itemsMapper.addItem(cart_items);

//        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
//        RedisConnection connection = connectionFactory.getConnection();

//        redisTemplate.opsForValue().set("name","zhangsan");
//        // 获取并打印这个key的值
//        System.out.println(redisTemplate.opsForValue().get("name"));


    }
    @Test
    public void test(){
//        Books books = new Books(1,"java",3,"111");
//        redisTemplate.opsForValue().set("user",books);
//
//        System.out.println(redisTemplate.opsForValue().get("user"));
    
    }
}
