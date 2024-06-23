package com.airport.Country.domain;

/**
 * Country
 */
public class Country {
    private String id;
    private String countryName;
    public Country() {
    }
    public Country(String countryName) {
        this.countryName = countryName;
    }
    public String getId() {
        return id;
    }
    public void setId(String string) {
        this.id = string;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
     
}