package com.airport.RevisionDetail.infrastructure.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airport.RevisionDetail.application.service.RevisionDetailService;
import com.airport.RevisionDetail.domain.RevisionDetail;

public class RevisionDetailController {
    private RevisionDetailService revisionDetailService;
    private Scanner input;

    public RevisionDetailController() {
        this.revisionDetailService = new RevisionDetailService();
        this.input = new Scanner(System.in);
    }

    private RevisionDetail save() {
        try {
            RevisionDetail revisionDetail = new RevisionDetail();
            System.out.println("Ingrese la descripción de la revisión: ");
            String description = input.nextLine();
            revisionDetail.setDescription(description);
            System.out.println("Ingrese el ID del empleado de revisión: ");
            Long revemployeeId = input.nextLong();
            input.nextLine(); // Limpiar buffer
            revisionDetail.setRevemployeeId(revemployeeId);
            RevisionDetail savedRevisionDetail = revisionDetailService.save(revisionDetail);
            if (savedRevisionDetail != null) {
                System.out.println("Revisión guardada exitosamente.");
            } else {
                System.out.println("Error al guardar la revisión.");
            }
            return savedRevisionDetail;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void listRevisionDetails() {
        List<RevisionDetail> revisionDetails = revisionDetailService.findAll();
        for (RevisionDetail revisionDetail : revisionDetails) {
            System.out.println(revisionDetail);
        }
    }

    private void getRevisionDetailById() {
        try {
            System.out.println("Ingrese el ID de la revisión: ");
            Long id = input.nextLong();
            input.nextLine(); // Limpiar buffer
            Optional<RevisionDetail> revisionDetail = revisionDetailService.findById(id);
            if (revisionDetail.isPresent()) {
                System.out.println(revisionDetail.get());
            } else {
                System.out.println("Revisión no encontrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteRevisionDetailById() {
        try {
            System.out.println("Ingrese el ID de la revisión a eliminar: ");
            Long id = input.nextLong();
            input.nextLine(); // Limpiar buffer
            revisionDetailService.deleteById(id);
            System.out.println("Revisión eliminada exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateRevisionDetail() {
        try {
            System.out.println("Ingrese el ID de la revisión a actualizar: ");
            Long id = input.nextLong();
            input.nextLine(); // Limpiar buffer
            Optional<RevisionDetail> optionalRevisionDetail = revisionDetailService.findById(id);
            if (optionalRevisionDetail.isPresent()) {
                RevisionDetail revisionDetail = optionalRevisionDetail.get();
                System.out.println("Ingrese la nueva descripción de la revisión: ");
                String description = input.nextLine();
                revisionDetail.setDescription(description);
                System.out.println("Ingrese el nuevo ID del empleado de revisión: ");
                Long revemployeeId = input.nextLong();
                input.nextLine(); // Limpiar buffer
                revisionDetail.setRevemployeeId(revemployeeId);
                revisionDetailService.update(revisionDetail);
                System.out.println("Revisión actualizada exitosamente.");
            } else {
                System.out.println("Revisión no encontrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarMenuRevisionDetail() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\nMenú de Gestión de Detalles de Revisiones");
            System.out.println("1. Registrar detalle de revisión");
            System.out.println("2. Listar detalles de revisiones");
            System.out.println("3. Consultar detalle de revisión por ID");
            System.out.println("4. Eliminar detalle de revisión");
            System.out.println("5. Actualizar detalle de revisión");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();  

            switch (opcion) {
                case 1:
                    this.save();
                    break;
                case 2:
                    this.listRevisionDetails();
                    break;
                case 3:
                    this.getRevisionDetailById();
                    break;
                case 4:
                    this.deleteRevisionDetailById();
                    break;
                case 5:
                    this.updateRevisionDetail();
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
