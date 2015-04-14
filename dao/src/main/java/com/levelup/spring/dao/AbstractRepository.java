package com.levelup.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by denis_zavadsky on 4/14/15.
 */
public abstract class AbstractRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    public T getById(Long id, Class entityClass){
        T object = (T) entityManager.find(entityClass, id);
        return object;
    }

    public T create(T object){
        entityManager.persist(object);
        return object;
    }
    public T update(T object){
        entityManager.merge(object);
        return object;
    }
    public boolean delete(Long id, Class entityClass){
        T objectForRemove = (T) entityManager.find(entityClass, id);
        entityManager.remove(objectForRemove);
        return true;
    }

}
