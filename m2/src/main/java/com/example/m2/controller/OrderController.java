package com.example.m2.controller;

import com.example.m2.dao.UserMapper;
import com.example.m2.pojo.Books;
import com.example.m2.pojo.Order;
import com.example.m2.pojo.User;
import com.example.m2.pojo.order_items;
import com.example.m2.service.BookServiceImpl;
import com.example.m2.service.OrderServiceImpl;
import com.example.m2.service.UserServiceImpl;
import com.example.m2.service.order_itemsServiceImpl;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private order_itemsServiceImpl order_itemsService;

    private List<String> order_noList = new ArrayList<>();
    @RequestMapping("/userorders")
    //查询属于用户的订单数据 并且返回到一个订单展示页面
    public String queryOrderstoUser(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
        } else {
             username = principal.toString();
        }
        System.out.println("查询订单");
        int user_id = userService.check(username).getId();
        List<Order> orderlist = orderService.queryOrdersByUserId(user_id);
        System.out.println(orderlist);
        model.addAttribute("orderlist", orderlist);

        return "orders/myorderlist";
    }

    @RequestMapping("/toaddOrder/{id}")
    public String toaddOrder(@PathVariable("id") int id,Model model){
        System.out.println("添加到订单");
        Books book = bookService.queryBookById(id);
        model.addAttribute("book", book);
        return "orders/addorder";
    }

//    @RequestMapping("/addOrder")
//    public String addOrder(Order order){
//        orderService.addOrder(order);
//        return "myorderlist";
//    }
    @RequestMapping("/createOrder/{bookName}")
    public String addOrder(@PathVariable("bookName") String bookName,Model model){
        System.out.println(bookName);
        Books book = bookService.queryBookName(bookName);

        if(book.getBookCounts()>0){
            //随机生成订单号
            String order_no;
            while(true) {
                 order_no = RandomStringUtils.randomAlphanumeric(10);

                if (!order_noList.contains(order_no)) {
                    order_noList.add(order_no);
                    break;
                }
                System.out.println("字符串已存在");
            }
            //获取userid
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username;
            if (principal instanceof UserDetails) {
                username = ((UserDetails)principal).getUsername();
            } else {
                username = principal.toString();
            }
            int user_id = userService.check(username).getId();
            int order_status = 1;
            //订单日期
            Date date = new Date();
            java.sql.Date sdate= new java.sql.Date(date.getTime());
            Order order = new Order(order_no,user_id,order_status,sdate);

            orderService.addOrder(order);


            //创建订单物品
            int bookID = book.getBookID();
            int quantity = 1;

            order_items items = new order_items(order_no,bookID,bookName,quantity);
            order_itemsService.addItem(items);
            bookService.deleteStack(bookID);
            System.out.println("订单添加成功");
        }else {
            model.addAttribute("no stack","no stack");
        }
        return "redirect:/userorders";
    }

    @RequestMapping("/toDeleteOrder/{order_no}")
    public String DeleteOrders(@PathVariable("order_no") String order_no) {
        System.out.println("删除订单");
        order_items item = order_itemsService.queryItemByOrderNo(order_no);
        System.out.println(item);
        int bookID = item.getBookID();
        orderService.deleteOrderByNo(order_no);
        order_itemsService.deleteItemById(item.getId());
        bookService.addStack(bookID);
        return "redirect:/userorders";
    }
}
