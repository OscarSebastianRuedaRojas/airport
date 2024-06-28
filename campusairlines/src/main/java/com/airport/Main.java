package com.airport;

<<<<<<< HEAD
import com.airport.Tecnico.infrastructure.adapter.in.TecnicoController;
=======
>>>>>>> Felipe

public class Main {
    public static void main(String[] args) {
        // AdminController adminController = new AdminController();
        // adminController.mostrarMenuAdmin();
<<<<<<< HEAD
        TecnicoController tecnicoController = new TecnicoController();
        tecnicoController.RevisionManager();
=======
>>>>>>> Felipe
    }
    public static void printA320SeatDiagram() {
                // Parte superior del avión
                System.out.println("                 _________");
                System.out.println("                /         \\");
                System.out.println("               /           \\");
                System.out.println("              /             \\");
                System.out.println("             /               \\");
                System.out.println("            /_________________\\");
                
                // Asientos
                int row = 1;
                while (row <= 35) {
                    System.out.printf("            | %2d  A B C   D E F |\n", row);
                    row++;
                }
                
                // Parte inferior del avión
                System.out.println("            \\                 /");
                System.out.println("             \\               /");
                System.out.println("              \\             /");
                System.out.println("               \\           /");
                System.out.println("                \\_________/");
            }
}