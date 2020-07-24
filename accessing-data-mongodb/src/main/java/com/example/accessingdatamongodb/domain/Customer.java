package com.example.accessingdatamongodb.domain;

import org.springframework.data.annotation.Id;

import java.util.*;

public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String emailAddress; // should be unique

    private Set<String> groupIds;

    public Customer() {}

    public Customer(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.groupIds = new HashSet<>();
    }

    public Customer(String firstName, String lastName, String emailAddress, Set<String> groupIds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.groupIds = groupIds;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void addGroup(String groupId) {
        groupIds.add(groupId);
    }

    public void deleteGroup(String groupId) {
        if (!groupIds.isEmpty() && groupIds.contains(groupId)) {
            groupIds.remove(groupId);
        }
    }

    public Set<String> getGroupIds() {
        return groupIds;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", groupIds=" + groupIds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                emailAddress.equals(customer.emailAddress) &&
                Objects.equals(groupIds, customer.groupIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, emailAddress, groupIds);
    }
}
