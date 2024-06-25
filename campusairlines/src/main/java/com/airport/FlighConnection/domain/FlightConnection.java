package com.airport.FlighConnection.domain;

/**
 * FlighConnection
 */
public class FlightConnection {

    private Long id;
    private String connection_number;
    private Long trip_id;
    private Long plane_id;
    private Long airport_id;
    
    public FlightConnection() {
    }

    public FlightConnection(Long id, String connection_number, Long trip_id, Long plane_id, Long airport_id) {
        this.id = id;
        this.connection_number = connection_number;
        this.trip_id = trip_id;
        this.plane_id = plane_id;
        this.airport_id = airport_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConnection_number() {
        return connection_number;
    }

    public void setConnection_number(String connection_number) {
        this.connection_number = connection_number;
    }

    public Long getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(Long trip_id) {
        this.trip_id = trip_id;
    }

    public Long getPlane_id() {
        return plane_id;
    }

    public void setPlane_id(Long plane_id) {
        this.plane_id = plane_id;
    }

    public Long getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(Long airport_id) {
        this.airport_id = airport_id;
    }

    
}