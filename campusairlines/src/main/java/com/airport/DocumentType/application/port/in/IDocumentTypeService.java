package com.airport.DocumentType.application.port.in;

import java.util.List;
import com.airport.DocumentType.domain.DocumentType;

/**
 * DocumentTypeService
 */
public interface IDocumentTypeService {
    DocumentType createDocumentType(DocumentType documentType);
    List<DocumentType> listDocumentType();
    void updateDocumentType(DocumentType documentType);
    DocumentType getDocumentType(Long id);
}