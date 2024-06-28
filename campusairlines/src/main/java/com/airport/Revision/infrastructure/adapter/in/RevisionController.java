package com.airport.Revision.infrastructure.adapter.in;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.airport.Plane.domain.Plane;
import com.airport.Plane.infrastructure.adapter.in.PlaneController;
import com.airport.Revision.application.service.RevisionService;
import com.airport.Revision.domain.Revision;
import com.airport.Revision.domain.RevisionDTO;

public class RevisionController {
    private RevisionService revisionService;
    private PlaneController planeController;
    private Scanner input;

    public RevisionController() {
        this.revisionService = new RevisionService();
        this.planeController = new PlaneController();
        this.input = new Scanner(System.in);
    }

    public void registerRevision() {
        Revision revision = new Revision();
        try {
            System.out.println("Ingresa la fecha de la revisión (YYYY-MM-DD):");
            revision.setRevisionDate(LocalDate.parse(input.nextLine()));
            String plates = planeController.listPlanes();
            Plane plane = planeController.getPlane(plates);
            revision.setPlaneId(plane.getId());
            if (verification(revision)) {
                System.out.println("La revision: " + revision + " ya esxiste.");
            } else {
                Revision revision2 = revisionService.createRevision(revision);
                if (revision2 == null) {
                    System.out.println("Hubo un error al guardar la revisión.");
                } else {
                    System.out.println("Revisión guardada exitosamente.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al guardar la revisión.");
            e.printStackTrace();
        }
        input.nextLine();
    }

    public Long listRevisions() {
        try {
            System.out.println("Revisiones disponibles: ");
            List<Revision> revisions = revisionService.getAllRevisions();
            for (Revision revision : revisions) {
                System.out.println(String.format("%d. Fecha: %s, ID del avión: %d",
                        revision.getId(), revision.getRevisionDate().toString(), revision.getPlaneId()));
            }
            System.out.println("Selecciona el id:");
            Long id = input.nextLong();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateRevision() {
        try {
            System.out.println("Ingresa el ID de la revisión a actualizar:");
            Long id = input.nextLong();
            input.nextLine(); // Consume el newline
            Revision revision = revisionService.getRevision(id);
            if (revision == null) {
                System.out.println("Revisión no encontrada.");
                return;
            }
            System.out.println("Ingresa la nueva fecha de la revisión (YYYY-MM-DD):");
            revision.setRevisionDate(LocalDate.parse(input.nextLine()));
            String plates = planeController.listPlanes();
            Plane plane = planeController.getPlane(plates);
            revision.setPlaneId(plane.getId());
            input.nextLine(); // Consume el newline
            revisionService.updateRevision(revision);
            System.out.println("Revisión actualizada exitosamente.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al actualizar la revisión.");
            e.printStackTrace();
        }
    }

    public void deleteRevision() {
        try {
            Long id = listRevisions();
            revisionService.deleteRevision(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verification(Revision newRevision) {
        List<Revision> revisions = revisionService.getAllRevisions();
        boolean[] flag = {false};
        revisions.forEach(revision -> {
            if (revision.getRevisionDate().equals(newRevision.getRevisionDate()) && revision.getPlaneId().equals(newRevision.getPlaneId())) {
                flag[0] = true;
            }
        });
        return flag[0];
    }
    public void getRevisionByPlanePlate() {
        try {
            String plate = planeController.listPlanes();
            List<RevisionDTO> planeRevisions = revisionService.getRevisionByPlanePlate(plate);
            planeRevisions.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void mostrarMenuRevision() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n Revisiones");
            System.out.println("1. Registrar revisión");
            System.out.println("2. Consultar información de revisión");
            System.out.println("3. Eliminar revisión");
            System.out.println("4. Actualizar datos de revisión");
            System.out.println("5. Consultar revisiones por matrícula de avión");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    registerRevision();
                    break;
                case 2:
                    Long id = listRevisions();
                    if (id != null) {
                        Revision revision = revisionService.getRevision(id);
                        if (revision != null) {
                            System.out.println("ID: " + revision.getId());
                            System.out.println("Fecha de revisión: " + revision.getRevisionDate());
                            System.out.println("ID del avión: " + revision.getPlaneId());
                        } else {
                            System.out.println("Revisión no encontrada.");
                        }
                    } else {
                        System.out.println("ID de revisión no válido.");
                    }
                    break;
                case 3:
                    deleteRevision();
                    System.out.println("Revisión eliminada exitosamente.");
                    break;
                case 4:
                    updateRevision();
                    break;
                case 5:
                    getRevisionByPlanePlate();
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
