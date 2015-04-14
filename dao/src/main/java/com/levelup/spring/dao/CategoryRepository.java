package com.levelup.spring.dao;

import com.levelup.spring.model.Category;

/**
 * Created by denis_zavadsky on 4/14/15.
 */
public interface CategoryRepository {

    public Category getById(Long id, Class entityClass);

    public Category create(Category object);

    public Category update(Category object);

    public boolean delete(Long id, Class entityClass);
}
