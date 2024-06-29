package com.airport.PaymentMethods.domain;

/**
 * paymentMethods
 */
public class PaymentMethods {

    private int id;
    private String methodName;
    public PaymentMethods() {
    }
    public PaymentMethods(String methodName) {
        this.methodName = methodName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    @Override
    public String toString() {
        return "PaymentMethods [id=" + id + ", methodName=" + methodName + "]";
    }
    
}