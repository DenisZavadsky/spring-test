package com.levelup.spring.model;

/**
 * Created by denis_zavadsky on 3/7/15.
 */
public class CarFactory {

    public Car getCar(String carVendor){
        switch (carVendor){
            case "Toyota": {
                return new ToyotaCar();
               // break;
            }
            case "Honda": {
                return new HondaCar();
               // break;
            }
            case "Hyundai": {
                return new HyundaiCar();
               // break;
            }
        }
        return null;
    }

    public static Car getHondaCar(){
        return new HondaCar();
    }

    public static Car getToyotaCar(){
        return new ToyotaCar();
    }
    public Car getHyundaiCar(){
        return new HyundaiCar();
    }
}
