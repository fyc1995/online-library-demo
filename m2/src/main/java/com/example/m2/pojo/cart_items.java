package com.example.m2.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class cart_items {

    private int id;
    private int cart_id;
    private int bookID;
    private String bookName;
    private int quantity;

    public cart_items(int cart_id, int bookID, String bookName, int quantity) {
        this.cart_id = cart_id;
        this.bookID = bookID;
        this.bookName = bookName;
        this.quantity = quantity;
    }
}
