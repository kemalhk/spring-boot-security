package com.security.springbootsecurity.repository;

import com.security.springbootsecurity.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
