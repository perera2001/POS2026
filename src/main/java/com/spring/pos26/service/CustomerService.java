package com.spring.pos26.service;

import com.spring.pos26.dto.CustomerDTO;
import com.spring.pos26.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService  {
    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerId(int customerId);

    List<CustomerDTO> getAllCustomers();
}
