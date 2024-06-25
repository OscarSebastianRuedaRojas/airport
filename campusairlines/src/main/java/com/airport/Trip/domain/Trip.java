package com.airport.Trip.domain;

import java.sql.Date;

/**
 * Trip
 */
public class Trip {

    private Long id;
    private Date trip_date;
    private float price_trip;
    private String departure_city_id;
    private String destination_city_id;
    
    public Trip() {
    }

    public Trip(Long id, Date trip_date, float price_trip, String departure_city_id, String destination_city_id) {
        this.id = id;
        this.trip_date = trip_date;
        this.price_trip = price_trip;
        this.departure_city_id = departure_city_id;
        this.destination_city_id = destination_city_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTrip_date() {
        return trip_date;
    }

    public void setTrip_date(Date trip_date) {
        this.trip_date = trip_date;
    }

    public float getPrice_trip() {
        return price_trip;
    }

    public void setPrice_trip(float price_trip) {
        this.price_trip = price_trip;
    }

    public String getDeparture_city_id() {
        return departure_city_id;
    }

    public void setDeparture_city_id(String departure_city_id) {
        this.departure_city_id = departure_city_id;
    }

    public String getDestination_city_id() {
        return destination_city_id;
    }

    public void setDestination_city_id(String destination_city_id) {
        this.destination_city_id = destination_city_id;
    }

    
}