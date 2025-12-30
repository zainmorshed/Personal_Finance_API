package com.finance.dto;

import java.math.BigDecimal;

public class FinanceBalanceResponse {
    private BigDecimal checkingBalance;
    private BigDecimal savingsBalance;
    
    public FinanceBalanceResponse() {}
    
    public FinanceBalanceResponse(BigDecimal checkingBalance, BigDecimal savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
    }
    
    public BigDecimal getCheckingBalance() { 
        return checkingBalance; 
    }
    
    public void setCheckingBalance(BigDecimal checkingBalance) { 
        this.checkingBalance = checkingBalance; 
    }
    
    public BigDecimal getSavingsBalance() { 
        return savingsBalance; 
    }
    
    public void setSavingsBalance(BigDecimal savingsBalance) { 
        this.savingsBalance = savingsBalance; 
    }
}