package com.spring.pos26.service;

import com.spring.pos26.dto.CustomerDTO;
import com.spring.pos26.dto.request.CustomerUpdateDTO;

public interface CustomerService  {
    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);
}
