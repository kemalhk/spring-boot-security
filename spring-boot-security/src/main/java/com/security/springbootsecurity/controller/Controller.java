package com.security.springbootsecurity.controller;

import com.security.springbootsecurity.dto.CustomerDto;
import com.security.springbootsecurity.model.Customer;
import com.security.springbootsecurity.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basic")
@RequiredArgsConstructor
public class Controller {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.saveCustomer(customerDto));
    }
}
