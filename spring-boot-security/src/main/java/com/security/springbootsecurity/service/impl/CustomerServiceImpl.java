package com.security.springbootsecurity.service.impl;

import com.security.springbootsecurity.dto.CustomerDto;
import com.security.springbootsecurity.model.Customer;
import com.security.springbootsecurity.repository.CustomerRepository;
import com.security.springbootsecurity.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Component
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public List<CustomerDto>getCustomers(){

        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer:customers) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setName(customer.getName());
            customerDto.setLastName(customer.getLastName());
            customerDto.setMail(customer.getMail());
            customerDto.setPhone(customer.getPhone());
            customerDto.setInvoiceAmount(customer.getInvoiceAmount());
            customerDto.setInstallment(customer.getInstallment());


            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setLastName(customerDto.getLastName());
        customer.setMail(customerDto.getMail());
        customer.setPhone(customerDto.getPhone());
        customer.setInvoiceAmount(customerDto.getInvoiceAmount());
        customer.setInstallment(customerDto.getInstallment());
        customerRepository.save(customer);

        return customerDto;
    }

}
