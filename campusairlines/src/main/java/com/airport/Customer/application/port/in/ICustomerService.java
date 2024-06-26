package com.airport.Customer.application.port.in;

import java.util.List;

import com.airport.Customer.domain.Customer;

/**
 * ICustomerService
 */
public interface ICustomerService {

    Customer save(Customer customer);
    Customer findById(String id);
    List<Customer> findAll();
    void deleteCustomer(String id);
    Customer updateCustomer(String id, Customer customer);
}