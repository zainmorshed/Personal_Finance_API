package com.finance.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generated ID
    private Long id;

    @Enumerated(EnumType.STRING) // Store enum as string
    private expenseType type;

    private double amount;

    @ManyToOne // Many transactions can belong to one category
    @JoinColumn(name = "category_id")
    private Category category;

    private LocalDateTime transactionDate;

    // Constructors
    public Transaction() {}


    // Getters & setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public expenseType getType() {
        return type;
    }
    public void setType(expenseType type) {
        this.type = type;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
