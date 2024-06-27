package com.airport.RevisionDetail.domain;



/**
 * RevisionDetail
 */
public class RevisionDetail {
    private Long id;
    private String description;
    private Long revemployeeId;
    public RevisionDetail(String description, Long revemployeeId) {
        this.description = description;
        this.revemployeeId = revemployeeId;
    }
    public RevisionDetail() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getRevemployeeId() {
        return revemployeeId;
    }
    public void setRevemployeeId(Long revemployeeId) {
        this.revemployeeId = revemployeeId;
    }
    @Override
    public String toString() {
        return "RevisionDetail [id=" + id + ", description=" + description + ", revemployeeId=" + revemployeeId + "]";
    }
    

    
}