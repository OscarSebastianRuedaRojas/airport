package com.airport.PaymentMethods.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.PaymentMethods.application.service.PaymentMethodsService;
import com.airport.PaymentMethods.domain.PaymentMethods;

/**
 * paymentMethodsController
 */
public class PaymentMethodsController {
    private final PaymentMethodsService paymentMethodsService;
    private final Scanner input;
    public PaymentMethodsController() {
        this.paymentMethodsService = new PaymentMethodsService();
        this.input = new Scanner(System.in);
    }
    public PaymentMethods save() {
        try {
            System.out.println("Nombre del método de pago:");
            String paymentMethodName = input.nextLine();
            input.nextLine();  
            PaymentMethods paymentMethods = new PaymentMethods(paymentMethodName);
            paymentMethodsService.createPaymentMethods(paymentMethods);
            System.out.println("Tipo Método de pago registrado exitosamente.");
            return paymentMethods;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void listPaymentMethodss() {
        try {
            List<PaymentMethods> paymentMethods = paymentMethodsService.listPaymentMethodss();
            paymentMethods.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void updatePaymentMethods() {
        try {
            System.out.println("Ingrese el ID del método de pago a actualizar:");
            int id = input.nextInt();
            input.nextLine();  // clear the buffer
            PaymentMethods existingPaymentMethods = paymentMethodsService.findPaymentMethodsById(id);
            if (existingPaymentMethods == null) {
                System.out.println("Tipo de Método de pago no encontrado.");
                return;
            }
            System.out.println("Ingrese el nuevo nombre del metodo de pago:");
            String method_name = input.nextLine();
            PaymentMethods updatedPaymentMethods = new PaymentMethods(method_name);
            paymentMethodsService.updatePaymentMethods(updatedPaymentMethods);
            System.out.println("Método de pago actualizado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showMenu() {
        int option = -1;
        while (option != 0) {
            System.out.println("\nMenú de Gestión de Métodos de Pago");
            System.out.println("1. Registrar tipo método de pago");
            System.out.println("2. Listar métodos de pago");
            System.out.println("3. Actualizar método de pago");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = input.nextInt();
            input.nextLine();  

            switch (option) {
                case 1:
                    this.save();
                    break;
                case 2:
                    this.listPaymentMethodss();
                    break;
                case 3:
                    this.updatePaymentMethods();
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