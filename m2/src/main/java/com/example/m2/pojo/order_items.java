package com.example.m2.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class order_items {
    private int id;
    private String order_no;
    private int bookID;
    private String bookName;
    private int quantity;

    public order_items(String order_no, int bookID, String bookName, int quantity) {
        this.order_no = order_no;
        this.bookID = bookID;
        this.bookName = bookName;
        this.quantity = quantity;
    }
}
