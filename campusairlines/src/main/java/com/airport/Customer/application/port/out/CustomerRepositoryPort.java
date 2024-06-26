package com.airport.Customer.application.port.out;

import java.util.List;

import com.airport.Customer.domain.Customer;

/**
 * CustomerRepositoryPort
 */
public interface CustomerRepositoryPort {

    Customer save(Customer customer);
    Customer findById(String id);
    List<Customer> findAll();
    void deleteCustomer(String id);
    Customer updateCustomer(String id, Customer customer);
}