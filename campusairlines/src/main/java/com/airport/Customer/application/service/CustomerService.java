package com.airport.Customer.application.service;

import java.util.List;

import com.airport.Customer.application.port.in.ICustomerService;
import com.airport.Customer.domain.Customer;
import com.airport.Customer.infrastructure.adapter.out.CustomerRepository;

/**
 * CustomerService
 */
public class CustomerService implements ICustomerService{
    private final CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    @Override
    public Customer save(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer findById(String id) {
        try {
            return customerRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteCustomer(String id) {
        try {
            customerRepository.deleteCustomer(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) {
        try {
            return customerRepository.updateCustomer(id, customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}