package com.matty.ex_7.util;

import com.matty.ex_7.enity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class MyRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("stuname");
        String gender = rs.getString("gender");
        Date birthday = rs.getDate("birthday");
        int score = rs.getInt("score");
        int stuno = rs.getInt("stuno");
        Student student = new Student();
        student.setStuname(name);
        student.setStuno(stuno);
        student.setBirthday(birthday);
        student.setGender(gender);
        student.setScore(score);
        return student;
    }
}
