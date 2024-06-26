package com.airport.Plane.infrastructure.adapter.in;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.airport.Airlines.infrastructure.adapter.in.AirlinesController;
import com.airport.Model.infrastructure.adapter.in.ModelController;
import com.airport.Plane.application.service.PlaneService;
import com.airport.Plane.domain.Plane;
import com.airport.Status.infrastructure.adapter.in.StatusController;

/**
 * PlaneController
 */
public class PlaneController {

    PlaneService planeService;
    Scanner input;

    public PlaneController() {
        this.planeService = new PlaneService();
        this.input = new Scanner(System.in);
    }

    public Plane save() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StatusController statusController = new StatusController();
        ModelController modelController = new ModelController();
        AirlinesController airlinesController = new AirlinesController();
        try {
            Plane plane = new Plane();
            System.out.println("Ingresa la matricula del Avion: ");
            plane.setPlates(input.nextLine());
            System.out.println("Ingresa la capacidad del Avion: ");
            plane.setCapacity(input.nextInt());
            input.nextLine();
            System.out.println("Ingresa la fecha de fabricacion del Avion(yyyy-MM-dd): ");
            String dateStr = input.nextLine();
            java.util.Date utilDate = dateFormat.parse(dateStr);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            plane.setFabrication_date(sqlDate);
            System.out.println("Selecciona el estado del Avion: ");
            plane.setStatus_id(statusController.listStatuses());
            System.out.println("Selecciona el modelo del Avion: ");
            plane.setModel_id(modelController.listModels());
            System.out.println("Selecciona la aerolinea del Avion: ");
            plane.setAirline_id(airlinesController.airlinesList());
            if (planeService.save(plane) != null) {
                System.out.println("El avion fue guardado exitosamente");
            }
            return plane;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String listPlanes() {
        try {
            List<Plane> planes = planeService.findAll();
            System.out.println("Ingresa la matricula del avion:");
            for (Plane plane : planes) {
                System.out.println(String.format("%s %d", plane.getPlates(), plane.getCapacity()));
            }
            String plates = input.nextLine().toUpperCase();
            return plates;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void informacionAvion() {
        try {
            String plates = this.listPlanes();
            Plane plane = planeService.consultarPlane(plates);
            if (plane == null) {
                System.out.println("Este avion no existe ");
                return;
            }
            System.out.println("La informacion del Avion con matricula: " + plane.getPlates());
            System.out.println("Capacidad: " + plane.getCapacity());
            System.out.println("Fecha de fabricacion " + plane.getFabrication_date());
            System.out.println("Estado: " + plane.getStatus());
            System.out.println("Modelo " + plane.getModel());
            System.out.println("Aerolinea: " + plane.getAirline());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarAvion() {
        try {
            String plates = this.listPlanes();
            planeService.eliminarPlane(plates);
            System.out.println(String.format("El avion con matricula %s fue eliminado exitosamente", plates));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarAvion() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StatusController statusController = new StatusController();
        ModelController modelController = new ModelController();
        AirlinesController airlinesController = new AirlinesController();
        try {
            String plates = this.listPlanes();
            Plane plane = new Plane();

            System.out.println("Ingresa la capacidad del Avion: ");
            plane.setCapacity(input.nextInt());
            input.nextLine();
            System.out.println("Ingresa la fecha de fabricacion del Avion(yyyy-MM-dd): ");
            String dateStr = input.nextLine();
            java.util.Date utilDate = dateFormat.parse(dateStr);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            plane.setFabrication_date(sqlDate);
            System.out.println("Selecciona el estado del Avion: ");
            plane.setStatus_id(statusController.listStatuses());
            System.out.println("Selecciona el modelo del Avion: ");
            plane.setModel_id(modelController.listModels());
            System.out.println("Selecciona la aerolinea del Avion: ");
            plane.setAirline_id(airlinesController.airlinesList());
            planeService.UpdatePlane(plates, plane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Plane getPlane(String plates) {
        try {
            return planeService.consultarPlane(plates);
        } catch (Exception e) {
            System.out.println("Erro al consultar avion por matricula.");
            e.printStackTrace();
        }
        return null;
    }
}