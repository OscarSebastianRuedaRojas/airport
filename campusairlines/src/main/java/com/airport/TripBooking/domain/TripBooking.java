package com.airport.TripBooking.domain;

import java.sql.Date;

/**
 * TripBooking
 */
public class TripBooking {

    private Long id;
    private Date date;
    private Long trip_id;
    
    public TripBooking() {
    }

    public TripBooking(Long id, Date date, Long trip_id) {
        this.id = id;
        this.date = date;
        this.trip_id = trip_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(Long trip_id) {
        this.trip_id = trip_id;
    }

    
}