package com.airport.FlightFare.domain;

/**
 * FlightFare
 */
public class FlightFare {
    private long id;
    private String description;
    private String details;
    private Double value;
    public FlightFare() {
    }
    public FlightFare(String description, String details, Double value) {
        this.description = description;
        this.details = details;
        this.value = value;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    
}