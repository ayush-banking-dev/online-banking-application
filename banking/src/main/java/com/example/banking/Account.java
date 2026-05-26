package com.example.banking;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Account holder name is required")
    private String accountHolderName;

    @NotNull(message = "Initial balance cannot be null")
    @Min(value = 0, message = "Balance cannot be less than zero")
    private Double balance;

    // Default Constructor
    public Account() {}

    // Constructor with fields
    public Account(String accountHolderName, Double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String accountHolderName) { this.accountHolderName = accountHolderName; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}