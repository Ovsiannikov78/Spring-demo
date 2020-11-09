package de.ovsiannikov.springdemo.service;

import de.ovsiannikov.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);
}
