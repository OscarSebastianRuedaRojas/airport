package com.airport.TripBookingDetail.domain;

/**
 * TripBookingDetail
 */
public class TripBookingDetail {

    private Long id;
    private Long tripBookingId;
    private String customerId;
    private int faresId;
    
    public TripBookingDetail() {
    }

    public TripBookingDetail(Long id, Long tripBookingId, String customerId, int faresId) {
        this.id = id;
        this.tripBookingId = tripBookingId;
        this.customerId = customerId;
        this.faresId = faresId;
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

    
}