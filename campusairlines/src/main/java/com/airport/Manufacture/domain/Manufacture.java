package com.airport.Manufacture.domain;


public class Manufacture {
    private Long id;
    private String manufacture_name;
    public Manufacture() {
    }
    public Manufacture(Long id, String manufacture_name) {
        this.id = id;
        this.manufacture_name = manufacture_name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getManufacture_name() {
        return manufacture_name;
    }
    public void setManufacture_name(String manufacture_name) {
        this.manufacture_name = manufacture_name;
    }

    
}