package com.levelup.spring.service.impl;

import com.levelup.spring.dao.CategoryRepository;
import com.levelup.spring.model.Category;
import com.levelup.spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by denis_zavadsky on 4/14/15.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getById(Long id) {
        return categoryRepository.getById(id, Category.class);
    }

    @Override
    public Category create(Category object) {
        return categoryRepository.create(object);
    }

    @Override
    public Category update(Category object) {
        return categoryRepository.update(object);
    }

    @Override
    public boolean delete(Long id) {
        return categoryRepository.delete(id, Category.class);
    }
}
