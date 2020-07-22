package com.example.accessingdatamongodb.controller;

import com.example.accessingdatamongodb.domain.Customer;
import com.example.accessingdatamongodb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/customer"})
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomer();
        return customers;
    }

    @PostMapping(value = "/{firstName}/{lastName}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addACustomer(@PathVariable String firstName, @PathVariable String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customerService.addACustomer(customer);
    }

}
