package com.airport.CustomerPayment.application.port.in;
import java.util.List;
import com.airport.CustomerPayment.domain.CustomerPayment;

public interface ICustomerPaymentService {
    CustomerPayment createCustomerPayment(CustomerPayment customerPayment);
    void updateCustomerPayment(int id, CustomerPayment customerPayment);
    void deleteCustomerPayment(int id);
    List<CustomerPayment> listCustomerPayments();
    CustomerPayment findCustomerPaymentById(int id);
}
