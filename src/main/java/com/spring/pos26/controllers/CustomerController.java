package com.spring.pos26.controllers;


import com.spring.pos26.dto.CustomerDTO;
import com.spring.pos26.dto.request.CustomerUpdateDTO;
import com.spring.pos26.service.CustomerService;
import com.spring.pos26.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customer")
@CrossOrigin
public class CustomerController {

@Autowired
private CustomerService customerService;

//@PostMapping(path = "/save")
//    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
//    String message = customerService.saveCustomer(customerDTO);
//    return message;
//
//
//}

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        String message = customerService.saveCustomer(customerDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );
        return response;


    }


    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {

    customerService.updateCustomer(customerUpdateDTO);
    return "success";
}

@GetMapping(path = "get")
    public String getCustomer() {
    return "success";
}

@GetMapping(
        path = "/get-by-id",
        params = "id"
)
    public CustomerDTO getCustomerById( @RequestParam(value = "id") int customerId) {
    CustomerDTO customerDTO = customerService.getCustomerId(customerId);
    return customerDTO;


     }

     @GetMapping(
             path = "/get-all-customers"
     )
    public ResponseEntity<StandardResponse> getAllCustomers() {
          List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",allCustomers),
                HttpStatus.OK
        );
     }

     @DeleteMapping(
             path = "delete-customer/{id}"
     )
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {
       String deleted=customerService.deleteCustomer(customerId);
       return deleted;

     }

}
