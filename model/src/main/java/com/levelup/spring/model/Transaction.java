package com.levelup.spring.model;

import java.util.Date;

/**
 * Created by denis_zavadsky on 4/4/15.
 */
public class Transaction {

    private Long id;
    private String accountNumber;
    private Float amount;
    private Date date;

    public Transaction() {
    }

    public Transaction(Long id, String accountNumber, Float amount, Date date) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
