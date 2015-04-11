package com.levelup.spring.service.impl;

import com.levelup.spring.dao.ProductRepository;
import com.levelup.spring.model.Product;
import com.levelup.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by denis_zavadsky on 4/11/15.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getCategoryProducts(Long categoryId) {
        return productRepository.getCategoryProducts(categoryId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Long createProduct(Product product) {
        return productRepository.createProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }
}
