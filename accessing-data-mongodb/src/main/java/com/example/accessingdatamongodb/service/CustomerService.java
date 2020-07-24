package com.example.accessingdatamongodb.service;

import com.example.accessingdatamongodb.domain.Customer;
import com.example.accessingdatamongodb.domain.Group;
import com.example.accessingdatamongodb.repository.CustomerRepository;
import com.example.accessingdatamongodb.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private GroupRepository groupRepository;

    public Customer addOrUpdateACustomer(Customer customer) {
        customer = customerRepository.save(customer);
        Set<String> groupIds = customer.getGroupIds();
        for (String groupId : groupIds) {
            if (groupRepository.findGroupById(groupId) == null) {
                Group insertedGroup = groupRepository.save(new Group(groupId, "Unknown", customer.getId()));
                insertedGroup.addCustomer(customer.getId());
                groupRepository.save(insertedGroup);
            }
            else {
                Group group = groupRepository.findGroupById(groupId);
                group.addCustomer(customer.getId());
                groupRepository.save(group);
            }

        }
        return customer;
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(String id) {return customerRepository.findCustomerById(id);}

    public Customer getCustomerByEmailAddress(String emailAddress) {return customerRepository.findCustomerByEmailAddress(emailAddress);}

    public List<Group> getGroupsACustomerJoins(Customer customer) {
        List<Group> groups = new ArrayList<>();
        if (customer == null) return groups;
        customer.getGroupIds().forEach(id -> groups.add(groupRepository.findGroupById(id)));
        return groups;
    }
}
