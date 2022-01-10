package com.matty.ex_7;


import com.matty.ex_7.service.JdbcService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;

public class JdbcTest {

    String xmlPath = "applicationContext.xml";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            xmlPath);
    JdbcService jdbcService = (JdbcService) applicationContext.getBean("jdbcService");

    @Test
    public void testOne(){
        jdbcService.createTable();
    }

    @Test
    public void testTwo() throws ParseException {
        jdbcService.insertRecord();
    }

    @Test
    public void testThree(){
        jdbcService.selectLast();
    }

    @Test
    public void testFour(){
        jdbcService.queryForWrapper();
    }

    @Test
    public void testFive(){
        try{
            jdbcService.deleteByScore();
        }catch (Exception e){
            System.out.println("删除失败");
        }
    }



}
