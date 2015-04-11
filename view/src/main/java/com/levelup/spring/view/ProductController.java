package com.levelup.spring.view;

import com.levelup.spring.model.Product;
import com.levelup.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by denis_zavadsky on 4/11/15.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<String> createProduct(@RequestParam String name,
                                                @RequestParam String code,
                                                @RequestParam String categoryId){
        Product product = new Product();
        product.setCategoryId(Long.parseLong(categoryId));
        product.setCode(code);
        product.setName(name);

        Long id = productService.createProduct(product);
        return new ResponseEntity<String>(id.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Product> getAllProducts(){
        List<Product> result = productService.getAllProducts();
        return result;
    }
}
