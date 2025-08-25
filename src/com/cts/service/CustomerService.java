package com.cts.service;

import com.cts.model.Customer;

public interface CustomerService {
	void addCustomer(String id, String name, String accountNumber);

	Customer getCustomer(String id);

	void deleteCustomer(String id);

}
