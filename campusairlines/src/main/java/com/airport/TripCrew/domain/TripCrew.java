package com.airport.TripCrew.domain;

/**
 * TripCrew
 */
public class TripCrew {

    private String employee_id;
    private Long connection_id;
    
    public TripCrew() {
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public Long getConnection_id() {
        return connection_id;
    }

    public void setConnection_id(Long connection_id) {
        this.connection_id = connection_id;
    }

    
}