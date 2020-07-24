package com.example.accessingdatamongodb.service;

import com.example.accessingdatamongodb.domain.Customer;
import com.example.accessingdatamongodb.domain.Group;
import com.example.accessingdatamongodb.repository.CustomerRepository;
import com.example.accessingdatamongodb.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    CustomerRepository customerRepository;

    public Group addAGroup(String groupName) {
        Group group = new Group(groupName);
        return groupRepository.save(group);
    }

    public Group addAGroup(Group group) {
        group = groupRepository.save(group);
        Set<String> customerIds = group.getCustomerIds();
        for (String customerId : customerIds) {
            if (customerRepository.findCustomerById(customerId) == null) {
                Customer insertedCustomer = customerRepository.save(new Customer(customerId, "Unknown", "Unknown"));
                insertedCustomer.addGroup(group.getId());
                customerRepository.save(insertedCustomer);
            }
            else {
                Customer customer = customerRepository.findCustomerById(customerId);
                customer.addGroup(group.getId());
                customerRepository.save(customer);
            }

        }
        return group;
    }

    public Group getGroupByName(String name) {
        return groupRepository.findGroupByGroupName(name);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    // get group with out child information -> field annotations

    public List<Customer> getCustomersBelongToTheGroup(Group group) {
        List<Customer> customers = new ArrayList<>();
        group.getCustomerIds().forEach(id -> customers.add(customerRepository.findCustomerById(id)));
        return customers;
    }

}
