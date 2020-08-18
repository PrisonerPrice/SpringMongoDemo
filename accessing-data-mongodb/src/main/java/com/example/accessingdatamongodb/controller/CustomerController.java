package com.example.accessingdatamongodb.controller;

import com.example.accessingdatamongodb.domain.Customer;
import com.example.accessingdatamongodb.domain.Group;
import com.example.accessingdatamongodb.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Customer Controller")
@RestController
@RequestMapping(value = {"/customer"})
//@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomer();
        return customers;
    }

    @GetMapping(value = "/{emailAddress}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Group> getAllGroupsACustomerJoinsByEmailAddress(@PathVariable String emailAddress) {
        Customer customer = customerService.getCustomerByEmailAddress(emailAddress);
        return customerService.getGroupsACustomerJoins(customer);
    }

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addACustomer(@RequestBody Customer customer) {
        customerService.addOrUpdateACustomer(customer);
    }

    @GetMapping(value = "/A")
    public Customer getAlice() {
        Customer alice = customerService.getCustomerByEmailAddress("AS@abc.com");
        return alice;
    }

}
