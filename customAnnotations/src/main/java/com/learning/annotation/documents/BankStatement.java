package com.learning.annotation.documents;

import com.learning.annotation.implementation.ValidName;

import java.util.List;

/**
 * Created by santoshk on 2/15/18.
 */
public class BankStatement implements BaseDocument {
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public BankStatement(String accountNumber, String customerName, List<Transaction> transactions, String address, String mobileNumber, String email) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.transactions = transactions;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String accountNumber;

    @ValidName(type="String")
    private String customerName;

    private List<Transaction> transactions;

    private String address;

    private String mobileNumber;

    private String email;


}