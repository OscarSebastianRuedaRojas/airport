package com.airport.Model.application.port.in;

import java.util.ArrayList;

import com.airport.Model.domain.Model;

/**
 * IModelService
 */
public interface IModelService {

    Model save(Model model);
    ArrayList<Model> listModels();
}