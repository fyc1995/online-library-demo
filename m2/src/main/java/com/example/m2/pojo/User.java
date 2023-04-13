package com.example.m2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private Date registerDate;
}
