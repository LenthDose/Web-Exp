package com.matty.ex_7.enity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {

    private int stuno;
    private String stuname;
    private Date birthday;
    private String gender;
    private int score;
}
