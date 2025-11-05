package com.finance.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.finance.entity.*;
import com.finance.Repo.AccountRepository;


@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not Found"));
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

}

/*
 * @Override is optional, but recommended
 * it tells java: "Im implementing a method from an interface or superclass"
 * 
 * Why it's useful:

Helps catch mistakes (e.g., if you misspell the method name or have wrong parameters).

Improves code readability.

You only use @Override when you're implementing a method from an interface or parent class.

💡 TL;DR: You’re telling Java, “Yes, I know I have to implement this method — here’s my version.”


 *  ✅ What's () -> doing?
This is a lambda expression, which is just a short way to write a function.
() -> new RuntimeException("User not Found")
means:
👉 “When this function is called, return a new RuntimeException.”
It's just a shortcut for:
new Supplier<RuntimeException>() {
    public RuntimeException get() {
        return new RuntimeException("User not Found");
    }
}


💡 So orElseThrow(() -> ...) lets you define what to throw only if needed, without creating a new class.
 */
