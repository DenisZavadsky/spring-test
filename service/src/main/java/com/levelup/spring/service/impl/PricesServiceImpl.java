package com.levelup.spring.service.impl;

import com.levelup.spring.model.dto.StockPrice;
import com.levelup.spring.service.PricesService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by denis_zavadsky on 3/24/15.
 */
@Service("pricesService")
public class PricesServiceImpl implements PricesService {

    private final static String APPLE="AAPL";
    private final static String EPAM="EPAM";
    private final static String FACEBOOK = "FB";

    @Override
    public StockPrice getStockPrice(String company) {
        StockPrice stockPrice = new StockPrice();
        Random random = new Random();
        if (APPLE.equals(company)){
            stockPrice.setPrice(new Float(random.nextInt(10000)/100));
            stockPrice.setVolume(random.nextInt(1000));
        }

        if (EPAM.equals(company)){
            stockPrice.setPrice(new Float(random.nextInt(1000)/100));
            stockPrice.setVolume(random.nextInt(100));
        }

        if (FACEBOOK.equals(company)){
            stockPrice.setPrice(new Float(random.nextInt(20000)/100));
            stockPrice.setVolume(random.nextInt(10000));
        }
        stockPrice.setCompany(company);
        return stockPrice;
    }
}
