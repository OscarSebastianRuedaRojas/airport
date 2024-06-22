package com.airport.Airlines.domain;

/**
 * Airlines
 */
public class Airlines {
    private Long id;
    private String airline_name;
    
    public Airlines() {
    }
    public Airlines(String airline_name) {
        this.airline_name = airline_name;
    }
    public Airlines(Long id, String airline_name) {
        this.id = id;
        this.airline_name = airline_name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getairline_name() {
        return airline_name;
    }
    public void setairline_name(String airline_name) {
        this.airline_name = airline_name;
    }
}