package com.cts.serviceimpl;

import java.util.List;

import com.cts.model.Customer;
import com.cts.model.Transaction;
import com.cts.service.CustomerService;
import com.cts.service.ReportService;
import com.cts.service.TransactionService;

public class ReportServiceImpl implements ReportService {
    private CustomerService customerService;
    private TransactionService transactionService;

    public ReportServiceImpl(CustomerService customerService, TransactionService transactionService) {
        this.customerService = customerService;
        this.transactionService = transactionService;
    }

    @Override
    public void generateCustomerReport(String customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("\n--- Customer Report ---");
        System.out.println(customer);

        List<Transaction> transactions = transactionService.getTransactionHistory(customerId);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("\nTransaction History:");
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }

    @Override
    public void generateBankSummary() {
        System.out.println("\n--- Bank Summary Report ---");

        List<Customer> allCustomers = null;
        try {
            allCustomers = ((CustomerServiceImpl) customerService).getAllCustomers(); 
        } catch (ClassCastException e) {
            System.out.println("Unable to retrieve customer list. Check service implementation.");
            return;
        }

        if (allCustomers == null || allCustomers.isEmpty()) {
            System.out.println("No customers found in the system.");
            return;
        }

        double totalBalance = 0;
        int count = 1;

        for (Customer customer : allCustomers) {
            System.out.println("Customer #" + count++);
            System.out.println(customer);
            totalBalance += customer.getAccount().getBalance();
            System.out.println("-------------------------------");
        }

        System.out.println("Total Customers: " + allCustomers.size());
        System.out.println("Total Bank Balance: $" + String.format("%.2f", totalBalance));
    }

}
