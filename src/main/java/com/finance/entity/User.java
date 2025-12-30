package com.finance.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private BigDecimal annualIncome;
    private BigDecimal checkingBalance;
    private BigDecimal savingsBalance;
//dont need parrameterized constructor since this will be...
// implemented dynamically during runtime by parsing the json ...
// body and mapping each value to their respective variables

    public User(){}

    public Long getId() {
        return id;
        
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public BigDecimal getCheckingBalance() {
        return checkingBalance;
    }

    public BigDecimal getSavingsBalance() {
        return savingsBalance;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    public void setCheckingBalance(BigDecimal checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public void setSavingsBalance(BigDecimal savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    


    
    
}
