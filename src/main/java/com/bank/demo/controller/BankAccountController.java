package com.bank.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.model.BankAccount;
import com.bank.demo.service.BankAccountService;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/{accountHolderName}")
    public BankAccount findByaccountHolderName(@PathVariable("accountHolderName") String accountHolderName) {
        return bankAccountService.findByaccountHolderName(accountHolderName);
    }

    @PostMapping("/create")
    public BankAccount createBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.Create(bankAccount);
    }

    @PutMapping("/update/deposit/{AccountHolderName}/{balance}")
    public BankAccount deposit(@PathVariable("AccountHolderName") String AccountHolderName,
            @PathVariable("balance") double balance) {
        BankAccount bankAccount = bankAccountService.findByaccountHolderName(AccountHolderName);
        return bankAccountService.Deposit(bankAccount, balance);
    }

    @PutMapping("/withdraw/update/{AccountHolderName}/{balance}")
    public BankAccount withdraw(@PathVariable("AccountHolderName") String AccountHolderName,
            @PathVariable("balance") double balance) {
        BankAccount bankAccount = bankAccountService.findByaccountHolderName(AccountHolderName);
        return bankAccountService.withdraw(bankAccount, balance);
    }

}
