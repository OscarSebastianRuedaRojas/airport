package com.airport.RevEmployee.domain;

/**
 * RevEmployee
 */
public class RevEmployee {

    private Long id;
    private String idEmployee;
    private Long idRevision;
    public RevEmployee() {
    }
    public RevEmployee(String idEmployee, Long idRevision) {
        this.idEmployee = idEmployee;
        this.idRevision = idRevision;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }
    public Long getIdRevision() {
        return idRevision;
    }
    public void setIdRevision(Long idRevision) {
        this.idRevision = idRevision;
    }
    @Override
    public String toString() {
        return "RevEmployee [id=" + id + ", idEmployee=" + idEmployee + ", idRevision=" + idRevision + "]";
    }
    

}