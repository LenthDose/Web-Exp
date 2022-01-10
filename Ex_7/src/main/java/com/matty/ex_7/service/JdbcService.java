package com.matty.ex_7.service;

import java.text.ParseException;

public interface JdbcService {

    void createTable();

    void insertRecord() throws ParseException;

    void selectLast();

    void queryForWrapper();

    void deleteByScore();
}
