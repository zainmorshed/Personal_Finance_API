package com.finance.service;

import com.finance.entity.Account;
import java.util.List;
import com.finance.entity.User;

public interface AccountService {

    Account createAccount(Account account);
    List<Account> getAccounts();
    Account getAccountById(Long id);
    void deleteAccount(Long id);
}
/*
 * implement these methods later
 */
