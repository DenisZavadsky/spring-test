package com.levelup.spring.service.impl;

import com.levelup.spring.dao.TransactionRepository;
import com.levelup.spring.model.Transaction;
import com.levelup.spring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by denis_zavadsky on 4/4/15.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.getAll();
    }

    @Override
    public List<Transaction> findByAccountNumber(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public Transaction getById(Long id) {
        return transactionRepository.getById(id);
    }
}
