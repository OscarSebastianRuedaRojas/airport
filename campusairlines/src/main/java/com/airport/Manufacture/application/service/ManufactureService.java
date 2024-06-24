package com.airport.Manufacture.application.service;

import java.util.List;

import com.airport.Manufacture.application.port.in.IManufactureService;
import com.airport.Manufacture.domain.Manufacture;
import com.airport.Manufacture.infrastructure.adapter.out.ManufactureRepository;

public class ManufactureService implements IManufactureService{
    ManufactureRepository manufactureRepository;

    
    public ManufactureService() {
        this.manufactureRepository = new ManufactureRepository();
    }

    @Override
    public Manufacture createManufacture(Manufacture Manufacture) {
        try {
            Manufacture createManufacture = manufactureRepository.save(Manufacture);
            return createManufacture;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Manufacture> listManufacture() {
        try {
            List<Manufacture> ManufactureList = manufactureRepository.findAll();
            return ManufactureList;
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    
}