package com.airport;

import com.airport.RevEmployee.infrastructure.adapter.in.RevEmployeeController;
import com.airport.Revision.infrastructure.adapter.in.RevisionController;
public class Main {
    public static void main(String[] args) {
        // AdminController adminController = new AdminController();
        // adminController.mostrarMenuAdmin();
        RevEmployeeController controller = new RevEmployeeController();
        RevisionController revConrtroController = new RevisionController();
        revConrtroController.mostrarMenuRevision();
        controller.mostrarMenuRevEmployee();

    }
}