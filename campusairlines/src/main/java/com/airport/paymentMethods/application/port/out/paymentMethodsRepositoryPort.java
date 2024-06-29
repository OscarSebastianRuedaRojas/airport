package com.airport.PaymentMethods.application.port.out;

import java.util.List;

import com.airport.PaymentMethods.domain.PaymentMethods;

/**
 * paymentMethodsRepositoryPort
 */
public interface PaymentMethodsRepositoryPort {

    PaymentMethods save(PaymentMethods paymentMethods);
    void update(PaymentMethods paymentMethods);
    void delete(int id);
    List<PaymentMethods> findAll();
    PaymentMethods findById(int id);
}