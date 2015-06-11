package com.levelup.spring.view;

import com.levelup.spring.model.dto.StockPrice;
import com.levelup.spring.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.xml.bind.ParseConversionEvent;
import java.text.ParseException;

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

    @RequestMapping(value = "/getUpdates", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody StockPrice getStockUpdates(@RequestParam("company") String company){
        //WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext()
        StockPrice price = pricesService.getStockPrice(company);
        return price;
    }

    @RequestMapping(value="/getUpdate/{id}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<StockPrice> getUpdateById(@PathVariable("id") Long id){
        try {
            StockPrice price = pricesService.getStockPrice("AAPL");
            throw new RuntimeException();
            //return new ResponseEntity<StockPrice>(price, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<StockPrice>(HttpStatus.BAD_REQUEST);
        }
    }

}
