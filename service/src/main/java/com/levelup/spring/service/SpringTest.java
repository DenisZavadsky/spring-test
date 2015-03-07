package com.levelup.spring.service;

import com.levelup.spring.model.Car;
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
       // TeacherService teacherService1 = (TeacherService) applicationContext.getBean("teacherService1");
        TeacherService teacherService1 = (TeacherService) applicationContext.getBean("teacherService");
        teacherService1.getAllTeachers();

        Car car = (Car) applicationContext.getBean("car");

        applicationContext.destroy();
        //teacherService2.getAllTeachers();
    }
}
