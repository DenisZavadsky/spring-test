package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.ProductRepository;
import com.levelup.spring.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by denis_zavadsky on 4/11/15.
 */
@Repository("productRepository")
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getCategoryProducts(Long categoryId) {
        Query query = entityManager.createNamedQuery("from Product p where p.catagoryId = :categoryId");
        query.setParameter("categoryId",categoryId);
        List<Product> products = query.getResultList();
        return products;
    }

    @Override
    public List<Product> getAllProducts() {
        Query query = entityManager.createQuery("from Product p");
        List<Product> products = query.getResultList();
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public Long createProduct(Product product) {
        entityManager.persist(product);
        return product.getId();
    }

    @Override
    public Product updateProduct(Product product) {
        entityManager.merge(product);
        return product;
    }
}
