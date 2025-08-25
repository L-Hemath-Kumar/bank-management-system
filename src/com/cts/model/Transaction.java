package com.cts.model;

import java.time.LocalDateTime;

public class Transaction {
    private String type; // e.g., DEPOSIT, WITHDRAW, TRANSFER
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + type + ": $" + String.format("%.2f", amount);
    }
}
