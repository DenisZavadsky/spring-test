package com.levelup.spring.service;

import com.levelup.spring.model.dto.StockPrice;

/**
 * Created by denis_zavadsky on 3/24/15.
 */
public interface PricesService {

    StockPrice getStockPrice(String company);
}
