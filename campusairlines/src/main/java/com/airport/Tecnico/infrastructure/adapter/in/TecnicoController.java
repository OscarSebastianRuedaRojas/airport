package com.airport.Tecnico.infrastructure.adapter.in;
import java.util.Scanner;

import com.airport.RevEmployee.infrastructure.adapter.in.RevEmployeeController;
import com.airport.Revision.infrastructure.adapter.in.RevisionController;
import com.airport.RevisionDetail.infrastructure.adapter.in.RevisionDetailController;
/**
 * TecnicoController
 */
public class TecnicoController {

    private RevisionController revisionController;
    private RevEmployeeController revEmployeeController;
    private RevisionDetailController revisionDetailController;
    private Scanner input;

    public TecnicoController() {
        this.revisionController =  new RevisionController();
        this.revEmployeeController = new RevEmployeeController();
        this.revisionDetailController = new RevisionDetailController();
        this.input = new Scanner(System.in);
    }
    
    public void RevisionManager() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\nMenú de Gestión de Revisiones");
            System.out.println("1. Administrar Revisiones");
            System.out.println("2. Administrar empleados de revisiones ");
            System.out.println("3. Administrar detalles de revisiones");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    revisionController.mostrarMenuRevision();
                    break;
                case 2:
                    revEmployeeController.mostrarMenuRevEmployee();
                    break;
                case 3:
                    revisionDetailController.mostrarMenuRevisionDetail();
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