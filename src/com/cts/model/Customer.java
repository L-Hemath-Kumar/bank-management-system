package com.cts.model;

public class Customer {
    private String customerId;
    private String name;
    private BankAccount account;

    public Customer(String customerId, String name, String accountNumber) {
        this.customerId = customerId;
        this.name = name;
        this.account = new BankAccount(accountNumber);
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public BankAccount getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + "\nName: " + name + "\n" + account.toString();
    }
}
