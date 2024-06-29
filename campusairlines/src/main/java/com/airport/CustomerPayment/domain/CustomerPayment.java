package com.airport.CustomerPayment.domain;

import java.sql.Date;

public class CustomerPayment {
    private int id;
    private String customerId;
    private int paymentMethodId;
    private String cardNumber;
    private String cardHolderName;
    private Date cardExpiryDate;


    public CustomerPayment() {
    }

    public CustomerPayment(String customerId, int paymentMethodId, String cardNumber, String cardHolderName, Date cardExpiryDate) {
        this.customerId = customerId;
        this.paymentMethodId = paymentMethodId;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardExpiryDate = cardExpiryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Date getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(Date cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }
    @Override
    public String toString() {

        return "CustomerPayment{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", paymentMethodId=" + paymentMethodId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardExpiryDate=" + cardExpiryDate +
                '}';
    }
}
