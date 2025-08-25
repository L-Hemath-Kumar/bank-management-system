package com.cts.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cts.model.Customer;
import com.cts.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private Map<String, Customer> customerMap = new HashMap<>();

    @Override
    public void addCustomer(String id, String name, String accountNumber) {
        if (customerMap.containsKey(id)) {
            System.out.println("Customer with ID " + id + " already exists.");
            return;
        }
        Customer customer = new Customer(id, name, accountNumber);
        customerMap.put(id, customer);
        System.out.println("Customer added successfully.");
    }

    @Override
    public Customer getCustomer(String id) {
        return customerMap.get(id);
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerMap.remove(id) != null) {
            System.out.println("Account Closed successfully.");
        } else {
            System.out.println("Customer with ID " + id + " not found.");
        }
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}
