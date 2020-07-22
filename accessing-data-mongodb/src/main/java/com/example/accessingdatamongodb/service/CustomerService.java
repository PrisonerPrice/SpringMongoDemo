package com.example.accessingdatamongodb.service;

import com.example.accessingdatamongodb.domain.Customer;
import com.example.accessingdatamongodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void addACustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
