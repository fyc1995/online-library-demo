package com.example.m2.pojo;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Books implements Serializable {
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
