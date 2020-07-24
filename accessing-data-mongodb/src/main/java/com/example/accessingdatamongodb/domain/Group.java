package com.example.accessingdatamongodb.domain;

import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {

    @Id
    private String id;

    private String groupName;
    private Set<String> customerIds;

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
        customerIds = new HashSet<>();
    }

    public Group(String groupName, Set<String> customerIds) {
        this.groupName = groupName;
        this.customerIds = customerIds;
    }

    public Group(String id, String groupName, String customerId) {
        this.id = id;
        this.groupName = groupName;
        this.customerIds = new HashSet<>();
        customerIds.add(customerId);
    }

    public String getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public Set<String> getCustomerIds() {
        return customerIds;
    }

    public void addCustomer(String customerId) {
        customerIds.add(customerId);
    }

    public void deleteCustomer(String customerId) {
        if (customerIds.contains(customerId)) {
            customerIds.remove(customerId);
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                ", customerIds=" + customerIds +
                '}';
    }
}
