package com.airport;

import com.airport.Tecnico.infrastructure.adapter.in.TecnicoController;

public class Main {
    public static void main(String[] args) {
        // AdminController adminController = new AdminController();
        // adminController.mostrarMenuAdmin();
        TecnicoController tecnicoController = new TecnicoController();
        tecnicoController.RevisionManager();
    }
}