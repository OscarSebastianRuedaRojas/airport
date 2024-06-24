package com.airport.Manufacture.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.Manufacture.application.service.ManufactureService;
import com.airport.Manufacture.domain.Manufacture;

public class ManufactureController {
    private ManufactureService manufactureService;
    private Scanner input;
    public ManufactureController() {
        this.manufactureService = new ManufactureService();
        this.input = new Scanner(System.in);
    }

    public void registerManufacture(){
        Manufacture manufacture = new Manufacture();
        try {
            System.out.println("Ingresa el nombre de la fabrica");
            manufacture.setManufacture_name(input.nextLine());
            Manufacture manufacture2 = manufactureService.createManufacture(manufacture);
            if (manufacture2 == null) {
                System.out.println("Hubo un error al guardar la fabrica");
            } else {
                System.out.println("Fabrica guardada exitosamente");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al guardar la fabrica");
            e.printStackTrace();
        }
        input.nextLine();
    }

    public Long ListManufactures(){
        try {
            System.out.println("Fabricas disponibles: ");
            List<Manufacture> manufactures = manufactureService.listManufacture();
            for (Manufacture manufacture : manufactures) {
                System.out.println(String.format("%d. %s", manufacture.getId(), manufacture.getManufacture_name()));
            }
            System.out.println("Selecciona el id:");
            Long id = input.nextLong();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}