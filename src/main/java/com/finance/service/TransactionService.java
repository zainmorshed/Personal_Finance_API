package com.finance.service;

import com.finance.entity.*;
import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    List<Transaction> getTransactions();
    Transaction getTransactionById(Long id);
    void deleteTransaction(Long id);
}
