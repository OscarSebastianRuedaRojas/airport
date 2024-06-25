package com.airport.Airport.domain;

/**
 * Airport
 */
public class Airport {
    private String id;
    private String name;
    private String cityId;
    public Airport() {
    }
    public Airport(String id, String name, String cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCityId() {
        return cityId;
    }
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
    @Override
    public String toString() {
        return "Airport [id = " + id + ", name = " + name + ", cityId = " + cityId + "]";
    }
    
}