package com.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finance.entity.*;
import com.finance.dto.FinanceBalanceResponse;
import com.finance.service.AccountService;
import com.finance.service.UserService;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private final UserService userService;

    @Autowired
    public AccountController(AccountService accountService, UserService userService){
        this.accountService = accountService;
        this.userService = userService;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping("/getAllAccounts")
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }
    
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return "Account with ID " + id + " has been deleted"; 
    }
    
    //NEW ENDPOINT
    @GetMapping("/balance")
    public FinanceBalanceResponse getBalance(@RequestParam String user) {
        try {
            User userEntity = userService.getUserByName(user);
            
          
            BigDecimal checking = userEntity.getCheckingBalance() != null ? 
                userEntity.getCheckingBalance() : BigDecimal.ZERO;
            BigDecimal savings = userEntity.getSavingsBalance() != null ? 
                userEntity.getSavingsBalance() : BigDecimal.ZERO;
            
            return new FinanceBalanceResponse(checking, savings);
            
        } catch (Exception e) {
            System.err.println("Error fetching balance for user: " + user + " - " + e.getMessage());
            return new FinanceBalanceResponse(BigDecimal.ZERO, BigDecimal.ZERO);
        }
    }
}