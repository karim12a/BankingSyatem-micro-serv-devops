package com.bank.accountservice.repository;

import com.bank.accountservice.entite.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
