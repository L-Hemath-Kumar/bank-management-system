package com.cts.model;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transferTo(BankAccount receiver, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            receiver.deposit(amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\nBalance: ₹" + String.format("%.2f", balance);
    }
}
