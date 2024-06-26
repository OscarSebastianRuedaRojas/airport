package com.airport.Revision.domain;

import java.time.LocalDate;

/**
 * Revision
 */
public class Revision {

    private Long id;
    private LocalDate revisionDate;
    private Long planeId;
    public Revision() {
    }
    public Revision(LocalDate revisionDate, Long planeId) {
        this.revisionDate = revisionDate;
        this.planeId = planeId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    @Override
    public String toString() {
        return "Revision [id=" + id + ", revisionDate=" + revisionDate + ", planeId=" + planeId + "]";
    }
    
}