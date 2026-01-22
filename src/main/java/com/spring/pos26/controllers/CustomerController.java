package com.spring.pos26.controllers;


import com.spring.pos26.dto.CustomerDTO;
import com.spring.pos26.dto.request.CustomerUpdateDTO;
import com.spring.pos26.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/customer")
@CrossOrigin
public class CustomerController {

@Autowired
private CustomerService customerService;

@PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
    String message = customerService.saveCustomer(customerDTO);
    return message;


}

@PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {

    customerService.updateCustomer(customerUpdateDTO);
    return "success";
}

}
