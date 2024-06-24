package com.airport.DocumentType.infrastructure.adapter.in;

import java.util.Scanner;
import com.airport.DocumentType.application.service.DocumentTypeService;
import com.airport.DocumentType.domain.DocumentType;

/**
 * DocumentTypeController
 */
public class DocumentTypeController {
    private DocumentTypeService documentTypeService;
    private Scanner input;
    public DocumentTypeController() {
        this.documentTypeService = new DocumentTypeService(null);
        this.input = new Scanner(System.in);
    }
    public void registerDocumentType() {
        try {
            System.out.println("Ingrese nombre del tipo de documento");
            String documentName = input.nextLine();
            DocumentType newDocumentType = new DocumentType(documentName);
            DocumentType createdDocumentType = documentTypeService.createDocumentType(newDocumentType);
            if (createdDocumentType == null) {
                System.out.println("No se pudo registrar.");
            } else {
                System.out.println(
                        " Registrado correctamente.\n\tNombre: " + createdDocumentType.getName() + ".");
            }

        } catch (Exception e) {
            System.out.println("Ocurrio un error al registrar. Reintente.");
            e.printStackTrace();
        }
    }
    
}