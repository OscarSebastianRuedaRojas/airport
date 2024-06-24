package com.airport.DocumentType.application.port.out;

import java.util.List;
import com.airport.DocumentType.domain.DocumentType;

/**
 * DocumentTypeRepositoryPort
 */
public interface DocumentTypeRepositoryPort {

    DocumentType findById(Long id); 
    DocumentType findByName(String typeName);
    List<DocumentType> findAll();
    DocumentType save(DocumentType documentType);
    void delete(Long id);
    void update(Long id, String newTypeName);
}