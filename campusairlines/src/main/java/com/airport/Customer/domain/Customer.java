package com.airport.Customer.domain;

/**
 * Customer
 */
public class Customer {

    private String id;
    private String customer_name;
    private int customer_age;
    private Long document_type_id;
    
    public Customer() {
    }

    
    public Customer(String id, String customer_name, int customer_age, Long document_type_id) {
        this.id = id;
        this.customer_name = customer_name;
        this.customer_age = customer_age;
        this.document_type_id = document_type_id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getCustomer_age() {
        return customer_age;
    }

    public void setCustomer_age(int customer_age) {
        this.customer_age = customer_age;
    }

    public Long getDocument_type_id() {
        return document_type_id;
    }

    public void setDocument_type_id(Long document_type_id) {
        this.document_type_id = document_type_id;
    }


    @Override
    public String toString() {
        return "Customer [id=" + id + ", customer_name=" + customer_name + ", customer_age=" + customer_age
                + ", document_type_id=" + document_type_id + "]";
    }

    
}