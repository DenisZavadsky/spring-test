package com.levelup.spring.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by denis_zavadsky on 3/5/15.
 */
public class SpringTest {

    public static void main(String[] args) {
        SpringTest test = new SpringTest();
        test.doTest();
    }

    public void doTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("service.xml");
        TeacherService teacherService1 = (TeacherService) applicationContext.getBean("teacherService1");
        TeacherService teacherService2 = (TeacherService) applicationContext.getBean("teacherService2");
        teacherService1.getAllTeachers();
        teacherService2.getAllTeachers();
    }
}
