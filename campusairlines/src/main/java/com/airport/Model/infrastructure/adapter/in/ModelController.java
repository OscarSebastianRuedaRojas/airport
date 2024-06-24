package com.airport.Model.infrastructure.adapter.in;

import java.util.ArrayList;
import java.util.Scanner;

import com.airport.Manufacture.infrastructure.adapter.in.ManufactureController;
import com.airport.Model.application.service.ModelService;
import com.airport.Model.domain.Model;

/**
 * ModelController
 */
public class ModelController {

    ModelService modelService;
    Scanner input;

    public ModelController() {
        this.modelService = new ModelService();
        this.input = new Scanner(System.in);
    }

    public void registerModel(){
        try {
            Model model = new Model();
            System.out.println("Ingresa el modelo que deseas registrar");
            model.setName(input.nextLine());
            ManufactureController manufactureController = new ManufactureController();
            model.setId_Manufacture(manufactureController.ListManufactures());
            modelService.save(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long listModels(){
        try {
            System.out.println("Modelos disponibles: ");
            ArrayList<Model> models = modelService.listModels();
            for (Model model : models) {
                System.out.println(String.format("%d. %s Fabrica: %s", model.getId(), model.getName(), model.getName_Manufacture()));
            }
            Long id = input.nextLong();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}