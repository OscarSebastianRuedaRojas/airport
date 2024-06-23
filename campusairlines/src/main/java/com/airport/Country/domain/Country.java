package com.airport.Country.domain;

/**
 * Country
 */
public class Country {
    private Long id;
    private String countryName;
    public Country() {
    }
    public Country(String countryName) {
        this.countryName = countryName;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
     
}