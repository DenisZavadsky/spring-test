package com.levelup.spring.dao;

import com.levelup.spring.model.Transaction;

import java.util.List;

/**
 * Created by denis_zavadsky on 4/4/15.
 */

public interface TransactionRepository {

    List<Transaction> getAll();
    List<Transaction> findByAccountNumber(String accountNumber);
    Transaction getById(Long id);
}
