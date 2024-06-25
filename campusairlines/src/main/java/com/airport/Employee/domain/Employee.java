package com.airport.Employee.domain;

import java.sql.Date;

/**
 * Employee
 */
public class Employee {

    private String id;
    private String employee_name;
    private Long rol_id;
    private Date admission_date;
    private Long airline_id;
    private String airport_id;

    public Employee() {
    }
    
    public Employee(String id, String employee_name, Long rol_id, Date admission_date, Long airline_id,
            String airport_id) {
        this.id = id;
        this.employee_name = employee_name;
        this.rol_id = rol_id;
        this.admission_date = admission_date;
        this.airline_id = airline_id;
        this.airport_id = airport_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Long getRol_id() {
        return rol_id;
    }

    public void setRol_id(Long rol_id) {
        this.rol_id = rol_id;
    }

    public Date getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
    }

    public Long getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(Long airline_id) {
        this.airline_id = airline_id;
    }

    public String getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(String airport_id) {
        this.airport_id = airport_id;
    }

    
}