package com.matty.ex_7;

import com.matty.ex_7.service.Impl.StudentImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {

    String xmlPath = "applicationContext.xml";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            xmlPath);
    StudentImpl student = (StudentImpl) applicationContext.getBean("student");

    @Test
    public void test(){
        student.test();
    }
}
