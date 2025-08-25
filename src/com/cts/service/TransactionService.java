package com.cts.service;

import java.util.List;

import com.cts.model.Transaction;

public interface TransactionService {
	
	void deposit(String customerId, double amount);

	void withdraw(String customerId, double amount);

	void transfer(String fromId, String toId, double amount);

	List<Transaction> getTransactionHistory(String customerId);
	
	double viewBalance(String customerId);

}
