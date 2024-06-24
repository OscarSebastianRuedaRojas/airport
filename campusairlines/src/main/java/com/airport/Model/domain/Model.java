package com.airport.Model.domain;

/**
 * Model
 */
public class Model {

    private Long id;
    private String name;
    private Long id_Manufacture;
    
    public Model() {
    }

    public Model(Long id, String name, Long id_Manufacture) {
        this.id = id;
        this.name = name;
        this.id_Manufacture = id_Manufacture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_Manufacture() {
        return id_Manufacture;
    }

    public void setId_Manufacture(Long id_Manufacture) {
        this.id_Manufacture = id_Manufacture;
    }

    
}