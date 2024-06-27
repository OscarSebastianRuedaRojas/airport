package com.airport.RevEmployee.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.Employee.infrastructure.adapter.in.EmployeeController;
import com.airport.RevEmployee.application.service.RevEmployeeService;
import com.airport.RevEmployee.domain.RevEmployee;

/**
 * RevEmployeeController
 */
public class RevEmployeeController {

    private RevEmployeeService revEmployeeService;
    private EmployeeController employeeController;
    private Scanner input;

    public RevEmployeeController() {
        this.revEmployeeService = new RevEmployeeService();
        this.employeeController = new EmployeeController();
        this.input = new Scanner(System.in);
    }

    private RevEmployee save() {
        try {
            RevEmployee revEmployee = new RevEmployee();
            System.out.println("Ingresa el ID del Empleado: ");
            employeeController.listEmployees();
            revEmployee.setIdEmployee(input.nextLine());
            System.out.println("Ingresa el ID de la Revisión: ");
            revEmployee.setIdRevision(input.nextLong());
            input.nextLine(); 
            if (revEmployeeService.save(revEmployee) != null) {
                System.out.println("El empleado de revisión fue guardado exitosamente");
            }
            return revEmployee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String listRevEmployees() {
        try {
            List<RevEmployee> revEmployees = revEmployeeService.findAll();
            System.out.println("Ingresa el ID del empleado:");
            for (RevEmployee revEmployee : revEmployees) {
                System.out.println(String.format("%d %s %d", revEmployee.getId(), revEmployee.getIdEmployee(), revEmployee.getIdRevision()));
            }
            String idEmployee = input.nextLine().toUpperCase();
            return idEmployee;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void informacionRevEmployee() {
        try {
            String idEmployee = this.listRevEmployees();
            Long id = Long.parseLong(idEmployee);
            RevEmployee revEmployee = revEmployeeService.findById(id).orElse(null);
            if (revEmployee == null) {
                System.out.println("Este empleado de revisión no existe ");
                return;
            }
            System.out.println("La información del Empleado de Revisión con ID: " + revEmployee.getId());
            System.out.println("ID Empleado: " + revEmployee.getIdEmployee());
            System.out.println("ID Revisión: " + revEmployee.getIdRevision());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarRevEmployee() {
        try {
            String idEmployee = this.listRevEmployees();
            Long id = Long.parseLong(idEmployee);
            revEmployeeService.deleteById(id);
            System.out.println(String.format("El empleado de revisión con ID %s fue eliminado exitosamente", idEmployee));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void actualizarRevEmployee() {
        try {
            String idEmployee = this.listRevEmployees();
            Long id = Long.parseLong(idEmployee);
            RevEmployee revEmployee = new RevEmployee();

            System.out.println("Ingresa el nuevo ID del Empleado: ");
            employeeController.listEmployees();
            revEmployee.setIdEmployee(input.nextLine());
            System.out.println("Ingresa el nuevo ID de la Revisión: ");
            revEmployee.setIdRevision(input.nextLong());
            input.nextLine(); 

            revEmployee.setId(id);
            revEmployeeService.update(revEmployee);
            System.out.println("El empleado de revisión fue actualizado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarMenuRevEmployee() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\nMenú de Gestión de Empleados de Revisión");
            System.out.println("1. Registrar empleado de revisión");
            System.out.println("2. Consultar información de empleado de revisión");
            System.out.println("3. Eliminar empleado de revisión");
            System.out.println("4. Actualizar datos de empleado de revisión");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();  

            switch (opcion) {
                case 1:
                    this.save();
                    break;
                case 2:
                    this.informacionRevEmployee();
                    break;
                case 3:
                    this.eliminarRevEmployee();
                    break;
                case 4:
                    this.actualizarRevEmployee();
                    break;
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    public RevEmployee getRevEmployee(Long id) {
        try {
            return revEmployeeService.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("Error al consultar empleado de revisión por ID.");
            e.printStackTrace();
        }
        return null;
    }
}
