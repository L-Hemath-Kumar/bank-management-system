package com.cts;

import java.util.Scanner;
import com.cts.serviceimpl.CustomerServiceImpl;
import com.cts.serviceimpl.ReportServiceImpl;
import com.cts.serviceimpl.TransactionServiceImpl;

public class Main {
    public static void main(String[] args) {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        TransactionServiceImpl transactionService = new TransactionServiceImpl(customerService);
        ReportServiceImpl reportService = new ReportServiceImpl(customerService, transactionService);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n --- Bank Application Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Generate Customer Report");
            System.out.println("6. Generate Bank Summary");
            System.out.println("7. Close Account");
            System.out.println("8. View Balance");
            System.out.println("9. Exit");
            System.out.println("----------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Customer ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    customerService.addCustomer(id, name, accNum);
                }
                case 2 -> {
                    System.out.print("Enter Customer ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Deposit Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    transactionService.deposit(id, amount);
                }
                case 3 -> {
                    System.out.print("Enter Customer ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Withdrawal Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    transactionService.withdraw(id, amount);
                }
                case 4 -> {
                    System.out.print("Enter Sender Customer ID: ");
                    String fromId = scanner.nextLine();
                    System.out.print("Enter Receiver Customer ID: ");
                    String toId = scanner.nextLine();
                    System.out.print("Enter Transfer Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    transactionService.transfer(fromId, toId, amount);
                }
                case 5 -> {
                    System.out.print("Enter Customer ID: ");
                    String id = scanner.nextLine();
                    reportService.generateCustomerReport(id);
                }
                case 6 -> reportService.generateBankSummary();
                case 7 -> {
                    System.out.print("Enter Customer ID to delete: ");
                    String id = scanner.nextLine();
                    customerService.deleteCustomer(id);
                }
                case 8 -> {
                    System.out.print("Enter Customer ID: ");
                    String id = scanner.nextLine();
                    double balance = transactionService.viewBalance(id);
                    if (balance >= 0) {
                        System.out.println(" Current Balance: $" + String.format("%.2f", balance));
                    } else {
                        System.out.println(" Customer not found.");
                    }
                }
                case 9 -> {
                    System.out.println("Exiting application. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
