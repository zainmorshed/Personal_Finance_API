package com.finance.service;

import com.finance.Repo.TransactionRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finance.entity.Transaction;
import com.finance.service.*;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactions(){
        return transactionRepository.findAll();
    }
    
    public Transaction getTransactionById(Long id){
        return transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not Found"));
    }

    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }
    
}
