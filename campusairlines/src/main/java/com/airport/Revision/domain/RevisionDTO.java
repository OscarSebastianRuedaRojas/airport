package com.airport.Revision.domain;
import java.time.LocalDate;

public class RevisionDTO {
    private Long id;
    private String employeeName;
    private int rolId;
    private LocalDate admissionDate;
    private int airlineId;
    private String airportId;
    private String description;
    private LocalDate revisionDate;
    private Long planeId;
    private String plates;
    private int capacity;
    private LocalDate fabricationDate;
    private int statusId;
    private int modelId;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirportId() {
        return airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(LocalDate revisionDate) {
        this.revisionDate = revisionDate;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long planeId) {
        this.planeId = planeId;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(LocalDate fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    @Override
    public String toString() {
        return String.format(
            "Informe de Revisión:\n" +
            "ID: %d\n" +
            "Nombre del Empleado: %s\n" +
            "ID del Rol: %d\n" +
            "Fecha de Admisión: %s\n" +
            "ID de la Aerolínea: %d\n" +
            "ID del Aeropuerto: %s\n" +
            "Descripción: %s\n" +
            "Fecha de Revisión: %s\n" +
            "ID del Avión: %d\n" +
            "Matrículas: %s\n" +
            "Capacidad: %d\n" +
            "Fecha de Fabricación: %s\n" +
            "ID del Estado: %d\n" +
            "ID del Modelo: %d\n",
            id, employeeName, rolId, admissionDate, airlineId, airportId, description, revisionDate, planeId, plates, capacity, fabricationDate, statusId, modelId);
    }
}
