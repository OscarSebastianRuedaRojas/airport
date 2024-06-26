package com.airport.TripBookingDetail.domain;

/**
 * TripBookingDetail
 */
public class TripBookingDetail {

    private Long id;
    private Long tripBookingId;
    private String customerId;
    private int faresId;
    private String seat;
    private int customerPaymentId;
    
    public TripBookingDetail() {
    }

    public TripBookingDetail(Long tripBookingId, String customerId, int faresId, String seat, int customerPaymentId) {
        this.tripBookingId = tripBookingId;
        this.customerId = customerId;
        this.faresId = faresId;
        this.seat = seat;
        this.customerPaymentId = customerPaymentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTripBookingId() {
        return tripBookingId;
    }

    public void setTripBookingId(Long tripBookingId) {
        this.tripBookingId = tripBookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getFaresId() {
        return faresId;
    }

    public void setFaresId(int faresId) {
        this.faresId = faresId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getCustomerPaymentId() {
        return customerPaymentId;
    }

    public void setCustomerPaymentId(int customerPaymentId) {
        this.customerPaymentId = customerPaymentId;
    }

    

    
}