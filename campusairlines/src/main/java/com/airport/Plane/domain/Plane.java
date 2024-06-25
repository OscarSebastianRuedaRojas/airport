package com.airport.Plane.domain;

import java.sql.Date;

/**
 * Plane
 */
public class Plane {

    private Long id;
    private String plates;
    private int capacity;
    private Date fabrication_date;
    private Long status_id;
    private String status;
    private Long model_id;
    private String model;
    private Long airline_id;
    private String airline;

    public Plane() {
    }

    public Plane(Long id, String plates, int capacity, Date fabrication_date, Long status_id, Long model_id,
            Long airline_id) {
        this.id = id;
        this.plates = plates;
        this.capacity = capacity;
        this.fabrication_date = fabrication_date;
        this.status_id = status_id;
        this.model_id = model_id;
        this.airline_id = airline_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getFabrication_date() {
        return fabrication_date;
    }

    public void setFabrication_date(Date fabrication_date) {
        this.fabrication_date = fabrication_date;
    }

    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Long status_id) {
        this.status_id = status_id;
    }

    public Long getModel_id() {
        return model_id;
    }

    public void setModel_id(Long model_id) {
        this.model_id = model_id;
    }

    public Long getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(Long airline_id) {
        this.airline_id = airline_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
    

    
}