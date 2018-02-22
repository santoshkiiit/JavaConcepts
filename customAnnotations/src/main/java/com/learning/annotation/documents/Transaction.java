package com.learning.annotation.documents;

import com.learning.annotation.implementation.ValidDate;

import java.util.Date;

/**
 * Created by santoshk on 2/15/18.
 */
public class Transaction {

    private String id;

    public String getId() {
        return id;
    }

    public Transaction(String id, String description, double amount, Date transactionTime) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.transactionTime = transactionTime;
    }

    public void setId(String id) {
        this.id = id;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    private String description;

    private double amount;

    @ValidDate(type=Date.class)
    private Date transactionTime;
}
