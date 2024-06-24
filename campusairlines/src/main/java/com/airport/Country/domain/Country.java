package com.airport.Country.domain;

/**
 * Country
 */
public class Country {
    private String id;
    private String countryName;
    public Country() {
    }

    public Country(String id, String countryName) {
        this.id = id;
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
    @Override
    public String toString() {
        return "Country [id = " + id + ", countryName = " + countryName + "]";
    }
     
}