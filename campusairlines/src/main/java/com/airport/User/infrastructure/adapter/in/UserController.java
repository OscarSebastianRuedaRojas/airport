package com.airport.User.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.Admin.infrastructure.adapter.in.AdminController;
import com.airport.CustomerMenu.infrastructure.CustomerMenuController;
import com.airport.SellAgent.infraestructure.adapter.SellAgentController;
import com.airport.Tecnico.infrastructure.adapter.in.TecnicoController;
import com.airport.User.application.Service.UserService;
import com.airport.User.domain.User;
import com.airport.User.domain.UserType;

public class UserController {
    private UserService userService;
    private AdminController adminController;
    private SellAgentController sellAgentController;
    private TecnicoController tecnicoController;
    private CustomerMenuController customerMenuController;
    private Scanner input;

    public UserController() {
        this.userService = new UserService();
        this.input = new Scanner(System.in);
        this.sellAgentController = new SellAgentController();
        this.adminController = new AdminController();
        this.tecnicoController = new TecnicoController();
        this.customerMenuController = new CustomerMenuController();
    }

    public void registerUserAdmin() {
        System.out.println("Ingrese su ID (cédula): ");
        String id = input.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String password = input.nextLine();

        System.out.println("Seleccione el tipo de usuario:");
        List<UserType> userTypes = userService.getAllUserTypes();
        for (UserType userType : userTypes) {
            System.out.println(userType.getId() + ". " + userType.getName());
        }
        int userTypeId = input.nextInt();
        input.nextLine(); // Limpiar buffer

        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setUserTypeId(userTypeId);

        userService.registerUser(user);
        System.out.println("Usuario registrado exitosamente.");
    }

    public void registerCustomer() {
        System.out.println("Ingrese su ID (cédula): ");
        String id = input.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String password = input.nextLine();

        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setUserTypeId(4);

        userService.registerUser(user);
        System.out.println("Usuario registrado exitosamente.");
    }

    public void mostrarMenuSuperUsuario() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\nModo Superusuario");
            System.out.println("1. Crear Usuario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();  // limpiar el buffer

            switch (opcion) {
                case 1:
                    this.registerUserAdmin();
                    break;
                case 0:
                    System.out.println("Saliendo del modo superusuario...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }

    }

    public void loginUser() {
        System.out.println("Ingrese su ID (cédula): ");
        String id = input.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String password = input.nextLine();

        User user = userService.loginUser(id, password);
        if (user != null) {
            System.out.println("Login exitoso. Bienvenido " + user.getId());
            switch (user.getUserTypeId()) {
                case 1:
                    adminController.mostrarMenuAdmin(input);
                    break;
                case 2:
                    sellAgentController.menuSaleAgent(input);
                    break;
                case 3:
                    tecnicoController.RevisionManager();
                    break;
                case 4:
                    customerMenuController.mostrarMenuCustomer();
                    break;
                case 5:
                    this.mostrarMenuSuperUsuario();
                    break;
                default:
                    System.out.println("Tipo de usuario desconocido.");
            }
        } else {
            System.out.println("Credenciales incorrectas. Por favor intente nuevamente.");
        }
    }
}
