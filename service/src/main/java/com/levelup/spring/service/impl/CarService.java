package com.levelup.spring.service.impl;

import com.levelup.spring.model.Car;
import com.levelup.spring.model.CarFactory;
import com.levelup.spring.model.HondaCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by denis_zavadsky on 3/7/15.
 */
//@Component
public class CarService {

    @Autowired
    CarFactory carFactory;


    @Resource(name="car")
    Car car;

    @Resource(name = "cars")
    //@Autowired
    List<Car> cars;

    @Resource(name = "mySet")
    Set mySet;

    @Autowired
    Map<String, String> myMap;

    @PostConstruct
    public void init(){
        HondaCar car1 = (HondaCar) carFactory.getCar("Honda");

        System.out.println(car.getClass().getCanonicalName());
    }
}
