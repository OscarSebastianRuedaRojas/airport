package com.airport;

import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

import com.airport.Customer.infrastructure.adapter.in.CustomerBookingController;
import com.airport.CustomerPayment.infrastructure.adapter.in.CustomerPaymentController;
import com.airport.PaymentMethods.infrastructure.adapter.in.PaymentMethodsController;
import com.airport.User.infrastructure.adapter.in.UserController;


public class Main {
    public static void main(String[] args) {
        // UserController userController = new UserController();
        // Scanner input = new Scanner(System.in);
        // int option;

        // do {
        //     System.out.println("----- Menú Principal -----");
        //     System.out.println("1. Registrar usuario");
        //     System.out.println("2. Iniciar sesión");
        //     System.out.println("0. Salir");
        //     System.out.print("Seleccione una opción: ");
        //     option = input.nextInt();
        //     input.nextLine(); // Limpiar buffer

        //     switch (option) {
        //         case 1:
        //             userController.registerCustomer();
        //             break;
        //         case 2:
        //             userController.loginUser();
        //             break;
        //         case 0:
        //             System.out.println("Saliendo del sistema...");
        //             break;
        //         default:
        //             System.out.println("Opción inválida. Por favor, intente de nuevo.");
        //     }
        // } while (option != 0);

        // input.close();
        CustomerPaymentController troll = new CustomerPaymentController();
        troll.showMenu();
    }

}