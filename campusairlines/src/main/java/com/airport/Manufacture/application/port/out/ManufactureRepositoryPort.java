package com.airport.Manufacture.application.port.out;

import java.util.List;

import com.airport.Manufacture.domain.Manufacture;

public interface ManufactureRepositoryPort {
    Manufacture findById(Long id); 
    Manufacture findByName(String manufactureName);
    List<Manufacture> findAll();
    Manufacture save(Manufacture manufacture);
    void delete(Long id);
    void update(Long id, String newmanufactureName);
}