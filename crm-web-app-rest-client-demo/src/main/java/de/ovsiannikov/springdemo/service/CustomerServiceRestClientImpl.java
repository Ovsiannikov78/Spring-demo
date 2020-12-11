package de.ovsiannikov.springdemo.service;

import de.ovsiannikov.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

public class CustomerServiceRestClientImpl implements CustomerService {

    private RestTemplate restTemplate;

    private String crmRestUrl;

    private Logger logger = Logger.getLogger(getClass().getName());

    public CustomerServiceRestClientImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
        restTemplate = theRestTemplate;
        crmRestUrl = theUrl;

        logger.info("Loaded property: crm.rest.url=" + crmRestUrl);
    }

    @Override
    public List<Customer> getCustomers() {
        return null;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

    }

    @Override
    public Customer getCustomer(int theId) {
        return null;
    }

    @Override
    public void deleteCustomer(int theId) {

    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {
        return null;
    }
}
