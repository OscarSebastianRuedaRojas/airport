package com.airport;

import com.airport.Admin.infrastructure.adapter.in.AdminController;
public class Main {
    public static void main(String[] args) {
        AdminController adminController = new AdminController();
        adminController.mostrarMenuAdmin();
    }
}