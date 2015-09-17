package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.MongoCustomerDao;
import com.levelup.spring.model.mongo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by denis_zavadsky on 9/17/15.
 *
 */
@Repository
public class MongoCustomerDaoImpl implements MongoCustomerDao {

    @Autowired
    private MongoOperations mongoOperations;

    public Customer persist(Customer customer){
        mongoOperations.insert(customer);
        return customer;
    }

    public Customer findById(String id){
        Customer customer = mongoOperations.findById(id, Customer.class);
        return customer;
    }
}
