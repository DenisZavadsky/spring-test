package com.levelup.spring.dao.impl;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.levelup.spring.dao.TransactionRepository;
import com.levelup.spring.model.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by denis_zavadsky on 4/4/15.
 */
@Repository("transactionRepository")
public class TranactionRepositoryImpl implements TransactionRepository{

    private List<Transaction> transactionList = new ArrayList<>();

    @PostConstruct
    private void init(){
        transactionList.add(new Transaction(1L,"12724632752",100.0f,new Date()));
        transactionList.add(new Transaction(2L,"11111111111",10.0f,new Date()));
        transactionList.add(new Transaction(3L,"99999990000",20.0f,new Date()));
        transactionList.add(new Transaction(4L,"12724632752",150.0f,new Date()));
        transactionList.add(new Transaction(5L,"11111111111",40.0f,new Date()));
    }

    @Override
    public List<Transaction> getAll() {
        return transactionList;
    }

    @Override
    public List<Transaction> findByAccountNumber(final String accountNumber) {
        Predicate<Transaction> predicate = new Predicate<Transaction>() {
            @Override
            public boolean apply(Transaction transaction) {
                if (transaction.getAccountNumber().equalsIgnoreCase(accountNumber)){
                    return true;
                }
                return false;
            }
        };

        List<Transaction> result = new ArrayList<>(Collections2.filter(transactionList, predicate));
        return result;
    }

    @Override
    public Transaction getById(final Long id) {
        Predicate<Transaction> predicate = new Predicate<Transaction>() {
            @Override
            public boolean apply(Transaction transaction) {
                if (transaction.getId().equals(id)){
                    return true;
                }
                return false;
            }
        };
        List<Transaction> result = new ArrayList<>(Collections2.filter(transactionList, predicate));
        if (result.size()>0) return result.get(0);
        return null;
    }
}
