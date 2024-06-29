package com.airport.CustomerPayment.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.Customer.infrastructure.adapter.in.CustomerController;
import com.airport.CustomerPayment.application.service.CustomerPaymentService;
import com.airport.CustomerPayment.domain.CustomerPayment;
import com.airport.PaymentMethods.application.service.PaymentMethodsService;

/**
 * CustomerPaymentController
 */
public class CustomerPaymentController {

    private final CustomerPaymentService customerPaymentService;
    private final CustomerController customerController;
    private final PaymentMethodsService paymentMethodsService;
    private final Scanner input;

    public CustomerPaymentController() {
        this.customerPaymentService = new CustomerPaymentService();
        this.customerController = new CustomerController();
        this.paymentMethodsService = new PaymentMethodsService();
        this.input = new Scanner(System.in);
    }

    public CustomerPayment save() {
        try {
            System.out.println("Ingrese el ID del cliente:");
            customerController.listCustomers();
            String customerId = input.nextLine();
            System.out.println("Ingrese el ID del método de pago:");
            paymentMethodsService.listPaymentMethodss();
            int paymentMethodId = input.nextInt();
            input.nextLine();
            System.out.println("Ingrese el número de la tarjeta:");
            String cardNumber = input.nextLine();
            System.out.println("Ingrese el nombre del titular de la tarjeta:");
            String cardHolderName = input.nextLine();
            System.out.println("Ingrese la fecha de vencimiento de la tarjeta (yyyy-MM-dd):");
            String cardExpiryDateStr = input.nextLine();
            java.sql.Date cardExpiryDate = java.sql.Date.valueOf(cardExpiryDateStr);

            CustomerPayment customerPayment = new CustomerPayment(customerId, paymentMethodId, cardNumber, cardHolderName, cardExpiryDate);
            customerPaymentService.createCustomerPayment(customerPayment);
            System.out.println("Método de pago registrado exitosamente.");
            return customerPayment;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void listCustomerPayments() {
        try {
            List<CustomerPayment> customerPayments = customerPaymentService.listCustomerPayments();
            customerPayments.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCustomerPayment() {
        try {
            System.out.println("Ingrese el ID del método de pago a actualizar:");
            int id = input.nextInt();
            input.nextLine();  
            CustomerPayment existingCustomerPayment = customerPaymentService.findCustomerPaymentById(id);
            if (existingCustomerPayment == null) {
                System.out.println("Método de pago no encontrado.");
                return;
            }
            System.out.println("Ingrese el nuevo ID del cliente:");
            customerController.listCustomers();
            String customerId = input.nextLine();
            System.out.println("Ingrese el nuevo ID del método de pago:");
            paymentMethodsService.listPaymentMethodss();
            int paymentMethodId = input.nextInt();
            input.nextLine();  // clear the buffer
            System.out.println("Ingrese el nuevo número de la tarjeta:");
            String cardNumber = input.nextLine();
            System.out.println("Ingrese el nuevo nombre del titular de la tarjeta:");
            String cardHolderName = input.nextLine();
            System.out.println("Ingrese la nueva fecha de vencimiento de la tarjeta (yyyy-MM-dd):");
            String cardExpiryDateStr = input.nextLine();
            java.sql.Date cardExpiryDate = java.sql.Date.valueOf(cardExpiryDateStr);

            CustomerPayment updatedCustomerPayment = new CustomerPayment(customerId, paymentMethodId, cardNumber, cardHolderName, cardExpiryDate);
            customerPaymentService.updateCustomerPayment(id, updatedCustomerPayment);
            System.out.println("Método de pago actualizado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomerPayment() {
        try {
            System.out.println("Ingrese el ID del método de pago a eliminar:");
            paymentMethodsService.listPaymentMethodss();
            int id = input.nextInt();
            input.nextLine();  // clear the buffer
            customerPaymentService.deleteCustomerPayment(id);
            System.out.println("Método de pago eliminado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showMenu() {
        int option = -1;
        while (option != 0) {
            System.out.println("\nMenú de Gestión de Métodos de Pago");
            System.out.println("1. Registrar método de pago");
            System.out.println("2. Listar métodos de pago");
            System.out.println("3. Actualizar método de pago");
            System.out.println("4. Eliminar método de pago");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = input.nextInt();
            input.nextLine();  // limpiar el buffer

            switch (option) {
                case 1:
                    this.save();
                    break;
                case 2:
                    this.listCustomerPayments();
                    break;
                case 3:
                    this.updateCustomerPayment();
                    break;
                case 4:
                    this.deleteCustomerPayment();
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
