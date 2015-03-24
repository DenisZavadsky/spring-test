package com.levelup.spring.model.dto;

/**
 * Created by denis_zavadsky on 3/24/15.
 */
public class StockPrice {

    private String company;
    private Float price;
    private Integer volume;

    public StockPrice() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
