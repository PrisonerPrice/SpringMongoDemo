package com.example.accessingdatamongodb.repository;

import com.example.accessingdatamongodb.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findCustomerByFirstName(String firstName);
    List<Customer> findCustomerByLastName(String lastName);
    Customer findCustomerById(String id);
    Customer findCustomerByEmailAddress(String emailAddress);
}
