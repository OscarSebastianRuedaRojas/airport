package com.airport.Model.application.port.out;

import java.util.ArrayList;

import com.airport.Model.domain.Model;

/**
 * ModelRepositoryPort
 */
public interface ModelRepositoryPort {

    Model save(Model model);
    ArrayList<Model> findAll();
}