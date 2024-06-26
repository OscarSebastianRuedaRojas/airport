package com.airport.DocumentType.infrastructure.adapter.in;

import java.util.List;
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
    public Long selectDocumentTypeList() {
        try {
            System.out.println("Tipos registrados");
            List <DocumentType> docTypesList = documentTypeService.listDocumentType();
            docTypesList.forEach(System.out::println);
            System.out.println("Seleccione tipo.");
            Long tipoId = documentTypeService.listDocumentType().get(input.nextInt()-1).getId();
            return tipoId;
        } catch (Exception e) {
            System.out.println("Error no existe ese id");
            e.printStackTrace();
        }
        return null;
    }
    public void updateDocumentType() {
        Long documentTypeId = selectDocumentTypeList();
        DocumentType documentType = documentTypeService.getDocumentType(documentTypeId);
        System.out.println("Actualizar nombre del tipo de documento: " + documentType.getName());
        input.nextLine();
        System.out.println("Escriba nuevo nombre");
        String newName = input.nextLine();
        documentType.setName(newName);
        documentTypeService.updateDocumentType(documentType);
        System.out.println("Actualizado correctamente a " + documentType.getName());
    }
    public boolean confirmation(){
        System.out.println("¿Esta seguro de su eleccion?\n\t1. Sí\n\t2. No.");
        int option = input.nextInt();
        if (option == 1) {
            return true;
        }
        return false;
    }
    public void getAll() {
        try {
            List<DocumentType> documentTypesList = documentTypeService.listDocumentType();
            if (documentTypesList == null) {
                System.out.println("No hay documentos registrados");
            }
            documentTypesList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void get() {
        try {
            System.out.println("Ingrese el id del tipo de documento");
            Long id = input.nextLong();
            DocumentType  documentType = documentTypeService.getDocumentType(id);
            System.out.println(documentType);
        } catch (Exception e) {
            e.printStackTrace();        
        }
    }
    public void delete() {
        try {
            Long id = selectDocumentTypeList();
            DocumentType documentType = documentTypeService.getDocumentType(id);
            documentTypeService.deleteDocumentType(documentType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarMenuTipoDocumento() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\nMenú de Gestión de Tipos de Documentos");
            System.out.println("1. Registrar tipo de documento");
            System.out.println("2. Consultar tipo de documento por ID");
            System.out.println("3. Eliminar tipo de documento");
            System.out.println("4. Actualizar datos de tipo de documento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine(); // limpiar buffer
    
            switch (opcion) {
                case 1:
                    this.registerDocumentType();
                    break;
                case 2:
                    this.get();
                    break;
                case 3:
                    this.delete();
                    break;
                case 4:
                    this.updateDocumentType();
                    break;
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}