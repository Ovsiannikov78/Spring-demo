package de.ovsiannikov.springdemo.service;

import de.ovsiannikov.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
}
