package de.ovsiannikov.springdemo.dao;

import de.ovsiannikov.springdemo.entity.Customer;
import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);
}
