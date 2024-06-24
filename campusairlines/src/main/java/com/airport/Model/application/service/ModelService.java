package com.airport.Model.application.service;

import java.util.ArrayList;

import com.airport.Model.application.port.in.IModelService;
import com.airport.Model.domain.Model;
import com.airport.Model.infrastructure.adapter.out.ModelRepository;

/**
 * ModelService
 */
public class ModelService implements IModelService{
    ModelRepository modelRepository;

    

    public ModelService() {
        this.modelRepository = new ModelRepository();
    }

    @Override
    public Model save(Model model) {
        try {
            modelRepository.save(model);
            return model;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Model> listModels() {
        try {
            ArrayList<Model> models = modelRepository.findAll();
            return models;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}