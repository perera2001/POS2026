package com.spring.pos26.service.impl;

import com.spring.pos26.dto.CustomerDTO;
import com.spring.pos26.entity.Customer;
import com.spring.pos26.repo.CustomerRepo;
import com.spring.pos26.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumber(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return "Saved " + customer.getCustomerName();

    }
}
