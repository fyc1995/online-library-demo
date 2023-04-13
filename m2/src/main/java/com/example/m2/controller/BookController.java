package com.example.m2.controller;

import com.example.m2.pojo.Books;
import com.example.m2.pojo.order_items;
import com.example.m2.pojo.top5;
import com.example.m2.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @RequestMapping("/book")
    //查询全部数据 并且返回到一个书籍展示页面
    public String queryAllBooks(Model model) {
        List<Books> booksList = bookService.queryAllBooks();
        model.addAttribute("booklist", booksList);
        return "books/bookslist";
    }

    @RequestMapping("/toAddBook")
    public String toAddPage() {

        return "books/addBook";
    }

    @RequestMapping("book/addbook")
    public String addBooks(Books book) {

        bookService.addBooks(book);
        return "redirect:/book";
    }

    @RequestMapping("/book/toDeletebook/{id}")
    public String DeleteBooks(@PathVariable("id") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book";
    }

    @RequestMapping("/book/toUpdatebook/{id}")
    public String toUpdatePage(@PathVariable("id") int id, Model model) {
        Books book = bookService.queryBookById(id);
        model.addAttribute("book", book);
        return "books/updatebook";
    }
//

   @PostMapping("/updateBook")
    public String updateBook( Books book) {

        bookService.updateBook(book);
        return "redirect:/book";
    }
    @RequestMapping("/queryBook")
    public String queryBookName(String bookName,Model model){
        Books book = bookService.queryBookName(bookName);

        List<Books> booksList = new ArrayList<>();
        booksList.add(book);
        if(book==null){
            System.out.println("error");
            booksList=bookService.queryAllBooks();
            model.addAttribute("error","do not find this book");
        }

        model.addAttribute("booklist",booksList);
        return "books/user_bookslist";
    }
    @RequestMapping("/userbook")
    //查询全部数据 并且返回到一个书籍展示页面
    public String queryAllBookstoUser(Model model) {
        List<Books> booksList = bookService.queryAllBooks();
        model.addAttribute("booklist", booksList);
        return "books/user_bookslist";
    }
    @RequestMapping("/top5")
    public String querytop5(Model model) {
        List<top5> top5 = bookService.queryTop5();
        model.addAttribute("top5", top5);
        return "books/top5";
    }
    @RequestMapping("/addBooktoCart/{id}")
    public String addBooktoCart(@PathVariable("id") int id, Model model){
        return "";
    }
}