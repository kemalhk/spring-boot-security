package com.security.springbootsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private String id;
    private String name;
    private String lastName;
    private String mail;
    private String phone;
    private Double invoiceAmount;
    private Integer installment;
}
