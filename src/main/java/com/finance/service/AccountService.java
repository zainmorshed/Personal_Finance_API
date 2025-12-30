package com.finance.service;

import com.finance.entity.Account;
import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    List<Account> getAccounts();
    Account getAccountById(Long id);
    void deleteAccount(Long id);
    List<Account> getAccountsByUserId(Long userId); 
}