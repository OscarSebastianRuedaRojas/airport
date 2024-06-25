package com.airport.Employee.infrastructure.adapter.in;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.airport.Employee.application.service.EmployeeService;
import com.airport.Employee.domain.Employee;

/**
 * EmployeeController
 */
public class EmployeeController {

    private EmployeeService employeeService;
    private Scanner input;

    public EmployeeController() {
        this.employeeService = new EmployeeService();
        this.input = new Scanner(System.in);
    }

    public Employee save() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Employee employee = new Employee();
            System.out.println("Ingresa el ID del empleado: ");
            employee.setId(input.nextLine());
            System.out.println("Ingresa el nombre del empleado: ");
            employee.setEmployee_name(input.nextLine());
            System.out.println("Selecciona el ID del rol: ");
            employee.setRol_id(input.nextLong());
            input.nextLine(); // limpiar buffer
            System.out.println("Ingresa la fecha de admisión (yyyy-MM-dd): ");
            String dateStr = input.nextLine();
            java.util.Date utilDate = dateFormat.parse(dateStr);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            employee.setAdmission_date(sqlDate);
            System.out.println("Selecciona el ID de la aerolínea: ");
            employee.setAirline_id(input.nextLong());
            input.nextLine(); // limpiar buffer
            System.out.println("Selecciona el ID del aeropuerto: ");
            employee.setAirport_id(input.nextLine());

            if (employeeService.createEmployee(employee) != null) {
                System.out.println("El empleado fue guardado exitosamente");
            }
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void listEmployees() {
        try {
            List<Employee> employees = employeeService.listEmployees();
            System.out.println("Empleados registrados:");
            for (Employee employee : employees) {
                System.out.println(String.format("ID: %s, Nombre: %s, ID del rol: %d, Fecha de admisión: %s, ID de la aerolínea: %d, ID del aeropuerto: %s",
                        employee.getId(), employee.getEmployee_name(), employee.getRol_id(), employee.getAdmission_date().toString(),
                        employee.getAirline_id(), employee.getAirport_id()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void informacionEmployee() {
        try {
            System.out.println("Ingresa el ID del empleado:");
            String id = input.nextLine();
            Employee employee = employeeService.findEmployeeById(id);
            if (employee == null) {
                System.out.println("Este empleado no existe.");
                return;
            }
            System.out.println("La información del empleado con ID: " + employee.getId());
            System.out.println("Nombre: " + employee.getEmployee_name());
            System.out.println("ID del rol: " + employee.getRol_id());
            System.out.println("Fecha de admisión: " + employee.getAdmission_date());
            System.out.println("ID de la aerolínea: " + employee.getAirline_id());
            System.out.println("ID del aeropuerto: " + employee.getAirport_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarEmployee() {
        try {
            System.out.println("Ingresa el ID del empleado:");
            String id = input.nextLine();
            employeeService.deleteEmployee(id);
            System.out.println(String.format("El empleado con ID %s fue eliminado exitosamente", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarEmployee() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println("Ingresa el ID del empleado:");
            String id = input.nextLine();
            Employee employee = new Employee();
            System.out.println("Ingresa el nuevo nombre del empleado: ");
            employee.setEmployee_name(input.nextLine());
            System.out.println("Selecciona el nuevo ID del rol: ");
            employee.setRol_id(input.nextLong());
            input.nextLine(); // limpiar buffer
            System.out.println("Ingresa la nueva fecha de admisión (yyyy-MM-dd): ");
            String dateStr = input.nextLine();
            java.util.Date utilDate = dateFormat.parse(dateStr);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            employee.setAdmission_date(sqlDate);
            System.out.println("Selecciona el nuevo ID de la aerolínea: ");
            employee.setAirline_id(input.nextLong());
            input.nextLine(); // limpiar buffer
            System.out.println("Selecciona el nuevo ID del aeropuerto: ");
            employee.setAirport_id(input.nextLine());

            employeeService.updateEmployee(id, employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}