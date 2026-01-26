package com.spring.pos26.service.impl;

import com.spring.pos26.dto.CustomerDTO;
import com.spring.pos26.dto.request.CustomerUpdateDTO;
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

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer=customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customerRepo.save(customer);

        }else{
            throw  new RuntimeException("Customer not found");
        }
        return "updated " + customerUpdateDTO.getCustomerName();

    }

    @Override
    public CustomerDTO getCustomerId(int customerId) {
        if(customerRepo.existsById(customerId)) {
            Customer customer=customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO=new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.isActive()
            );
            return customerDTO;

        }else {
            throw  new RuntimeException("Customer not found");
        }
    }
}
