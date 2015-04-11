package com.levelup.spring.dao;

import com.levelup.spring.model.Product;

import java.util.List;

/**
 * Created by denis_zavadsky on 4/11/15.
 */
public interface ProductRepository {

    List<Product> getCategoryProducts(Long categoryId);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Long createProduct(Product product);
    Product updateProduct(Product product);

}
