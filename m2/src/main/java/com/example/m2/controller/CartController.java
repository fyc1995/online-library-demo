package com.example.m2.controller;

import com.example.m2.pojo.Books;
import com.example.m2.pojo.Cart;
import com.example.m2.pojo.cart_items;
import com.example.m2.service.BookService;
import com.example.m2.service.CartService;
import com.example.m2.service.Cart_itemsService;
import com.example.m2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private Cart_itemsService cart_itemsService;
    @Autowired
    private BookService bookService;


    public int getUserID(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        int user_id = userService.check(username).getId();

        return user_id;
    }
//    @RequestMapping("/tomycart")
//    public String tomyCart(Model model){
//        return "cart";
//    }
    @RequestMapping("/mycart")
    public String queryCart(Model model){
        System.out.println("查看我的购物车");
        Cart cart = null;
        int user_id = getUserID();
        if(cartService.queryCartByUserId(user_id)==null){
            Date date = new Date();
            java.sql.Date sdate= new java.sql.Date(date.getTime());
            cart = new Cart(user_id,sdate);
            cartService.createCart(cart);
        }
        //cart和用户通过用户id关联起来
        cart = cartService.queryCartByUserId(user_id);
        if(cart_itemsService.queryItemListByCartID(cart.getId()).isEmpty()){
            model.addAttribute("empty","your shopping cart is empty");
        }

            List<cart_items> cartItemslist = cart_itemsService.queryItemListByCartID(cart.getId());
        System.out.println(cartItemslist);
            model.addAttribute("cartItemslist",cartItemslist);
        return "cart";
    }
    @RequestMapping("/addtocart/{bookName}")
    public String addToCart(@PathVariable("bookName") String bookName){
        //将cart_items 和 cart 通过cartid关联起来
        int user_id = getUserID();
        if(cartService.queryCartByUserId(user_id)==null){
            Date date = new Date();
            java.sql.Date sdate= new java.sql.Date(date.getTime());
            Cart cart = new Cart(user_id,sdate);
            cartService.createCart(cart);
        }

        System.out.println("添加到购物车");
        Cart cart = cartService.queryCartByUserId(getUserID());

        Books book = bookService.queryBookName(bookName);

        int bookID = book.getBookID();
        int quantity = 1;
        cart_items cart_items = new cart_items(cart.getId(),bookID,bookName,quantity);
        cart_itemsService.addItem(cart_items);

        return "redirect:/userbook";
    }
    @RequestMapping("/deletefromcart/{id}")
    public String deletefromCart(@PathVariable("id") int id){
        cart_itemsService.deleteItemById(id);
        return "redirect:/mycart";
    }
}
