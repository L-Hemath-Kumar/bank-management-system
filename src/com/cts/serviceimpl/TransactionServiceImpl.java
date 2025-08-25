package com.cts.serviceimpl;

import com.cts.model.Customer;
import com.cts.model.Transaction;
import com.cts.service.CustomerService;
import com.cts.service.TransactionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private CustomerService customerService;
    private Map<String, List<Transaction>> transactionMap = new HashMap<>();

    public TransactionServiceImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void deposit(String customerId, double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        customer.getAccount().deposit(amount);
        logTransaction(customerId, new Transaction("DEPOSIT", amount));
        System.out.println("Deposit successful. New balance: $" + customer.getAccount().getBalance());
    }

    @Override
    public void withdraw(String customerId, double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        boolean success = customer.getAccount().withdraw(amount);
        if (success) {
            logTransaction(customerId, new Transaction("WITHDRAW", amount));
            System.out.println("Withdrawal successful. New balance: $" + customer.getAccount().getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    @Override
    public void transfer(String fromId, String toId, double amount) {
        if (amount <= 0) {
            System.out.println("Transfer amount must be greater than zero.");
            return;
        }

        Customer sender = customerService.getCustomer(fromId);
        Customer receiver = customerService.getCustomer(toId);

        if (sender == null && receiver == null) {
            System.out.println(" Both sender (ID: " + fromId + ") and receiver (ID: " + toId + ") not found.");
            return;
        } else if (sender == null) {
            System.out.println(" Sender not found. ID: " + fromId);
            return;
        } else if (receiver == null) {
            System.out.println(" Receiver not found. ID: " + toId);
            return;
        }

        boolean success = sender.getAccount().transferTo(receiver.getAccount(), amount);
        if (success) {
            logTransaction(fromId, new Transaction("TRANSFER TO " + toId, amount));
            logTransaction(toId, new Transaction("RECEIVED FROM " + fromId, amount));
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient balance. Transfer failed.");
        }
    }

    @Override
    public List<Transaction> getTransactionHistory(String customerId) {
        return transactionMap.getOrDefault(customerId, new ArrayList<>());
    }

    private void logTransaction(String customerId, Transaction transaction) {
        transactionMap.computeIfAbsent(customerId, k -> new ArrayList<>()).add(transaction);
    }
    @Override
    public double viewBalance(String customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return -1; 
        }
        return customer.getAccount().getBalance();
    }
}
