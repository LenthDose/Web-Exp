package com.matty.ex_7.service.Impl;

import com.matty.ex_7.enity.Student;
import com.matty.ex_7.service.JdbcService;
import com.matty.ex_7.util.DateUtil;
import com.matty.ex_7.util.MyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
public class JdbcServiceImpl implements JdbcService {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public void createTable(){
        String sql = " CREATE TABLE `student` ( \n" +
                "`stuno` int(11) NOT NULL AUTO_INCREMENT primary key ,\n" +
                "`stuname` varchar(255) DEFAULT NULL,\n" +
                "`birthday` date DEFAULT NULL,\n" +
                "`gender` varchar(255) DEFAULT NULL,\n" +
                "`score` int DEFAULT NULL)";
        jdbcTemplate.execute(sql);
        System.out.println("student表创建成功");
    }


    public void insertRecord() throws ParseException {
        String sql = "insert into student(stuname, birthday, gender, score) values (?, ?, ?, ?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"张三", DateUtil.format("2000-11-11"),"男", "277"});
        batchArgs.add(new Object[]{"李四", DateUtil.format("2001-7-12"),"男", "300"});
        batchArgs.add(new Object[]{"王五", DateUtil.format("2000-6-15"),"男", "289"});
        batchArgs.add(new Object[]{"高明", DateUtil.format("2000-3-27"),"男", "315"});
        batchArgs.add(new Object[]{"赵梅", DateUtil.format("2000-7-30"),"女", "230"});
        jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println("插入数据成功");
    }


    public void selectLast(){
        String sql = "select * from student order by stuno desc LIMIT 1";
        Student student = jdbcTemplate.queryForObject(sql, new MyRowMapper());
        String update = "update student set score = 377 where stuno = ?";
        int isSuccess = jdbcTemplate.update(update, student.getStuno());
        if (isSuccess == 1){
            System.out.println("修改成功");
        }
    }

    public void queryForWrapper(){
        String sql = "select * from student where gender = '女' and month(birthday)='7'";
        Student student = jdbcTemplate.queryForObject(sql,new MyRowMapper());
        System.out.println(student.getStuname()+"\n" +student.getBirthday());
    }


    @Override
    public void deleteByScore() {
        String sql = "delete from student where score > 200";
        jdbcTemplate.execute(sql);
        System.out.println("删除成功");
    }




}
