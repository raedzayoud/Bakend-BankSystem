package com.bank.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.demo.model.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
    @Query("select b from BankAccount b where b.accountholdername = ?1")
    BankAccount findByaccountholdername(String accountHolderName);

}
