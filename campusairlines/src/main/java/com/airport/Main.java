package com.airport;

import com.airport.Revision.infrastructure.adapter.in.RevisionController;
public class Main {
    public static void main(String[] args) {
        // AdminController adminController = new AdminController();
        // adminController.mostrarMenuAdmin();
        RevisionController controller = new RevisionController();
        controller.RevisionManager();

    }
}