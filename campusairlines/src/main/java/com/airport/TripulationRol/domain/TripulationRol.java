package com.airport.TripulationRol.domain;

public class TripulationRol {

    private Long id;
    private String rol_name;
    
    public TripulationRol() {
    }

    public TripulationRol(Long id, String rol_name) {
        this.id = id;
        this.rol_name = rol_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol_name() {
        return rol_name;
    }

    public void setRol_name(String rol_name) {
        this.rol_name = rol_name;
    }

    
}