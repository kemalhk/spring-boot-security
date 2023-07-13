package com.security.springbootsecurity.service;

import com.security.springbootsecurity.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto>getCustomers();
    CustomerDto saveCustomer(CustomerDto customerDto);
}
