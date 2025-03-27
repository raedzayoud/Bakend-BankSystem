package com.bank.demo.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.demo.model.BankAccount;
import com.bank.demo.repository.BankAccountRepository;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    // Get By Account Holder Name
    public BankAccount findByaccountHolderName(String AccountHolderName) {
        BankAccount bankAccount = bankAccountRepository.findByaccountholdername(AccountHolderName);
        if (bankAccount == null) {
            throw new NoSuchElementException("The Account Holder Name is not found");
        }
        return bankAccount;

    }

    // Post Account
    public BankAccount Create(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    // Deposit
    public BankAccount Deposit(BankAccount bankAccount, double balance) {
        if (balance < 0) {
            throw new NoSuchElementException("The balance must be > 0");
        } else {
            bankAccount.setBalance(bankAccount.getBalance() + balance);
            return bankAccountRepository.save(bankAccount);
        }

    }

    // withraw
    public BankAccount withdraw(BankAccount bankAccount, double price) {
        if (price < 0) {
            throw new NoSuchElementException("The price must be > 0");
        } else if (bankAccount.getBalance() - price < 0) {
            throw new NoSuchElementException("The price must be less than the balance");
        } else {
            bankAccount.setBalance(bankAccount.getBalance() - price);
            return bankAccountRepository.save(bankAccount);
        }

    }

}
