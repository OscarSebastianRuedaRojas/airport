package com.airport.PaymentMethods.application.service;

import java.util.List;

import com.airport.PaymentMethods.application.port.in.IPaymentMethodsService;
import com.airport.PaymentMethods.domain.PaymentMethods;
import com.airport.PaymentMethods.infrastructure.adapter.out.PaymentMethodsRepository;

/**
 * PaymentMethodsService
 */
public class PaymentMethodsService implements IPaymentMethodsService {

    private PaymentMethodsRepository paymentMethodsRepository;

    public PaymentMethodsService() {
        this.paymentMethodsRepository = new PaymentMethodsRepository();
    }

    @Override
    public PaymentMethods createPaymentMethods(PaymentMethods paymentMethods) {
       try {
            return paymentMethodsRepository.save(paymentMethods);
       } catch (Exception e) {
        e.printStackTrace();
       }
        return null;
    }

    @Override
    public void deletePaymentMethods(int id) {
         try {
            paymentMethodsRepository.delete(id);
       } catch (Exception e) {
        e.printStackTrace();
       }
        
    }

    @Override
    public PaymentMethods findPaymentMethodsById(int id) {
         try {
        return paymentMethodsRepository.findById(id);
       } catch (Exception e) {
        e.printStackTrace();
       }
        return null;
    }

    @Override
    public List<PaymentMethods> listPaymentMethodss() {
         try {
        return paymentMethodsRepository.findAll();
       } catch (Exception e) {
        e.printStackTrace();
       }
        return null;
    }

    @Override
    public void updatePaymentMethods(PaymentMethods paymentMethods) {
         try {
            paymentMethodsRepository.update(paymentMethods);
       } catch (Exception e) {
        e.printStackTrace();
       }
        
    }
}