package com.airport.CustomerPayment.application.service;

import java.util.List;

import com.airport.CustomerPayment.application.port.in.ICustomerPaymentService;
import com.airport.CustomerPayment.domain.CustomerPayment;
import com.airport.CustomerPayment.infrastructure.adapter.out.CustomerPaymentRepository;

public class CustomerPaymentService implements ICustomerPaymentService {

    private CustomerPaymentRepository customerPaymentRepository;

    public CustomerPaymentService() {
        this.customerPaymentRepository = new CustomerPaymentRepository();
    }

    @Override
    public CustomerPayment createCustomerPayment(CustomerPayment customerPayment) {
        try {
            return customerPaymentRepository.save(customerPayment);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCustomerPayment(int id, CustomerPayment customerPayment) {
        try {
            customerPaymentRepository.update(customerPayment, id);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomerPayment(int id) {
        try {
            customerPaymentRepository.delete(id);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
    }

    @Override
    public List<CustomerPayment> listCustomerPayments() {
        try {
            return customerPaymentRepository.findAll();
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerPayment findCustomerPaymentById(int id) {
        try {
            return customerPaymentRepository.findById(id);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }
}
