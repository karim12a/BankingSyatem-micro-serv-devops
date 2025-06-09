package com.bank.customerservice.repository;


import com.bank.customerservice.entite.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
