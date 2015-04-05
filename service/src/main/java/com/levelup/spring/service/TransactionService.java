package com.levelup.spring.service;

import com.levelup.spring.model.Transaction;

import java.util.List;

/**
 * Created by denis_zavadsky on 4/4/15.
 */
public interface TransactionService {

    List<Transaction> getAll();
    List<Transaction> findByAccountNumber(String accountNumber);
    Transaction getById(Long id);
}
