package com.airport.CustomerMenu.infrastructure;

import java.util.Scanner;
import com.airport.CustomerMenu.domain.CustomerMenu;

public class CustomerMenuController {
    private final CustomerMenu customerMenu;
    private final Scanner input;

    public CustomerMenuController() {
        this.customerMenu = new CustomerMenu();
        this.input = new Scanner(System.in);
    }

    public void mostrarMenuCustomer() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1. Buscar vuelo y reservar");
            System.out.println("2. Menu reservas");
            System.out.println("0. Regresar");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    customerMenu.getCustomerBookingController().CreateFlightBooking();
                    break;
                case 2:
                    customerMenu.getTripBookingDetailController().clienteMenu();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    break;
            }
        }
    }
}
