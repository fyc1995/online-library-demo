package com.example.m2.pojo;

import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    private int id;
    private String order_no;
    private int user_id;
    private int order_status;
    private Date order_date;

    public Order(String order_no, int user_id, int order_status, Date order_date) {
        this.order_no = order_no;
        this.user_id = user_id;
        this.order_status = order_status;
        this.order_date = order_date;
    }
}
