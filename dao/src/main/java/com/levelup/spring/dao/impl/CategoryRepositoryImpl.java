package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.AbstractRepository;
import com.levelup.spring.dao.CategoryRepository;
import com.levelup.spring.model.Category;
import org.springframework.stereotype.Component;

/**
 * Created by denis_zavadsky on 4/14/15.
 */
@Component("categoryRepository")
public class CategoryRepositoryImpl extends AbstractRepository<Category>  implements CategoryRepository{


}
