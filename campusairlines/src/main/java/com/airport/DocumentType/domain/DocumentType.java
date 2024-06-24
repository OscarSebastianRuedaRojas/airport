package com.airport.DocumentType.domain;

/**
 * DocumentType
 */
public class DocumentType {
    private Long id;
    private String name;
    public DocumentType() {
    }
    public DocumentType(String name) {
        this.name = name;
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
    @Override
    public String toString() {
        return "DocumentType [id = " + id + ", name = " + name + "]";
    }
    
    
}