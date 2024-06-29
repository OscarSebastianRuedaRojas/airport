package com.airport.CustomerPayment.application.port.out;

import java.util.List;
import com.airport.CustomerPayment.domain.CustomerPayment;

public interface CustomerPaymentRepositoryPort {
    CustomerPayment save(CustomerPayment customerPayment);
    void update(CustomerPayment customerPayment, int id);
    void delete(int id);
    List<CustomerPayment> findAll();
    CustomerPayment findById(int id);
}
