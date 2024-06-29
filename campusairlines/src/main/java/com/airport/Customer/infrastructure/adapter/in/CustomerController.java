package com.airport.Customer.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.Customer.application.service.CustomerService;
import com.airport.Customer.domain.Customer;

/**
 * CustomerController
 */
public class CustomerController {

    private final CustomerService customerService;
    private final Scanner input;

    public CustomerController() {
        this.customerService = new CustomerService();
        this.input = new Scanner(System.in);
    }

    public Customer save() {
        try {
            System.out.println("Ingrese el nombre del cliente:");
            String customerName = input.nextLine();
            System.out.println("Ingrese la edad del cliente:");
            int customerAge = input.nextInt();
            input.nextLine();  // clear the buffer
            System.out.println("Ingrese el ID del tipo de documento:");
            Long documentTypeId = input.nextLong();
            input.nextLine();  // clear the buffer
            Customer customer = new Customer(null, customerName, customerAge, documentTypeId);
            customerService.save(customer);
            System.out.println("Cliente registrado exitosamente.");
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void listCustomers() {
        try {
            List<Customer> customers = customerService.findAll();
            customers.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer() {
        try {
            System.out.println("Ingrese el ID del cliente a actualizar:");
            String id = input.nextLine();
            Customer existingCustomer = customerService.findById(id);
            if (existingCustomer == null) {
                System.out.println("Cliente no encontrado.");
                return;
            }
            System.out.println("Ingrese el nuevo nombre del cliente:");
            String customerName = input.nextLine();
            System.out.println("Ingrese la nueva edad del cliente:");
            int customerAge = input.nextInt();
            input.nextLine();  // clear the buffer
            System.out.println("Ingrese el nuevo ID del tipo de documento:");
            Long documentTypeId = input.nextLong();
            input.nextLine();  // clear the buffer
            Customer updatedCustomer = new Customer(id, customerName, customerAge, documentTypeId);
            customerService.updateCustomer(id, updatedCustomer);
            System.out.println("Cliente actualizado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer() {
        try {
            System.out.println("Ingrese el ID del cliente a eliminar:");
            String id = input.nextLine();
            customerService.deleteCustomer(id);
            System.out.println("Cliente eliminado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showMenu() {
        int option = -1;
        while (option != 0) {
            System.out.println("\nMenú de Gestión de Clientes");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = input.nextInt();
            input.nextLine();  // limpiar el buffer

            switch (option) {
                case 1:
                    this.save();
                    break;
                case 2:
                    this.listCustomers();
                    break;
                case 3:
                    this.updateCustomer();
                    break;
                case 4:
                    this.deleteCustomer();
                    break;
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
    public Customer getCustomer(String id) {
        return customerService.findById(id);
    }

}