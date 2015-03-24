package com.levelup.spring.view;

import com.levelup.spring.model.dto.StockPrice;
import com.levelup.spring.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by denis_zavadsky on 3/24/15.
 */
@Controller
public class PriceController {

    @Autowired
    private PricesService pricesService;

    @RequestMapping("/stock")
    public String getStockView(Model model){
        return "stock";
    }

    @RequestMapping(value = "/getUpdates", produces = "application/json")
    public @ResponseBody StockPrice getStockUpdates(@RequestParam("company") String company){
        StockPrice price = pricesService.getStockPrice(company);
        return price;
    }
}
