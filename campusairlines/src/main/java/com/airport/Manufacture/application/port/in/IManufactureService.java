package com.airport.Manufacture.application.port.in;

import java.util.List;

import com.airport.Manufacture.domain.Manufacture;


public interface IManufactureService {
    Manufacture createManufacture(Manufacture Manufacture);
    void updateManufacture(Long id, String newManufactureNamw);
    void deleteManufacture(Long id);
    List<Manufacture> listManufacture();
    Manufacture findManufactureById(Long id);
    Manufacture findManufactureByName(String ManufactureName);
}