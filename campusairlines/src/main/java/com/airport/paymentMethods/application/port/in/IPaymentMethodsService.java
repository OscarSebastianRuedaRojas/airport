package com.airport.PaymentMethods.application.port.in;

import java.util.List;
import com.airport.PaymentMethods.domain.PaymentMethods;

/**
 * paymentMethodsService
 */
public interface IPaymentMethodsService {
    
    PaymentMethods createPaymentMethods(PaymentMethods paymentMethods);
    void updatePaymentMethods(PaymentMethods paymentMethods);
    void deletePaymentMethods(int id);
    List<PaymentMethods> listPaymentMethodss();
    PaymentMethods findPaymentMethodsById(int id);

}