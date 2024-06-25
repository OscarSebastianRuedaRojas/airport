package com.airport.DocumentType.application.service;

import java.util.List;
import com.airport.DocumentType.application.port.in.IDocumentTypeService;
import com.airport.DocumentType.domain.DocumentType;
import com.airport.DocumentType.infrastructure.adapter.out.DocumentTypeRepository;

/**
 * DocumentTypeService
 */
public class DocumentTypeService implements IDocumentTypeService {
    private DocumentTypeRepository documentTypeRepository;

    public DocumentTypeService(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = new DocumentTypeRepository();
    }

    @Override
    public DocumentType createDocumentType(DocumentType documentType) {
        try {
            DocumentType createdDocumentType = documentTypeRepository.save(documentType);
            return createdDocumentType;
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
        
    }

    @Override
    public List<DocumentType> listDocumentType() {
        try {
            List<DocumentType> documentTypesList = documentTypeRepository.findAll();
            return documentTypesList;
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateDocumentType(DocumentType documentType) {
        try {
            documentTypeRepository.update(documentType.getId(), documentType.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public DocumentType getDocumentType(Long id) {
        try {
            return documentTypeRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}