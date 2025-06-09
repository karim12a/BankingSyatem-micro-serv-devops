package com.bank.accountservice.controller;

import com.bank.accountservice.client.CustomerRestClient;
import com.bank.accountservice.entite.BankAccount;
import com.bank.accountservice.model.Customer;
import com.bank.accountservice.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountRestController {
    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach(acc->
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()))
        );
        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount= bankAccountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
