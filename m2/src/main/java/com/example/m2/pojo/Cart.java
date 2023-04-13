package com.example.m2.pojo;

import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Cart {

    private int id;
    private int user_id;
    private Date cart_date;

    public Cart(int user_id, Date cart_date) {
        this.user_id = user_id;
        this.cart_date = cart_date;
    }
}
