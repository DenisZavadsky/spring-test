package com.levelup.spring.service;

import com.levelup.spring.model.Category;

/**
 * Created by denis_zavadsky on 4/14/15.
 */
public interface CategoryService {

    Category getById(Long id);

    Category create(Category object);

    Category update(Category object);

    boolean delete(Long id);
}
