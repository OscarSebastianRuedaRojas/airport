package com.airport;


import java.util.List;


import com.airport.Manufacture.domain.Manufacture;
import com.airport.Manufacture.infrastructure.adapter.out.ManufactureRepository;

public class Main {
    public static void main(String[] args) {
        ManufactureRepository manufactureRepository = new ManufactureRepository();
        List<Manufacture> manufactures =  manufactureRepository.findAll();
        for (Manufacture manufacture : manufactures) {
            System.out.println(manufacture.getManufacture_name());
        }
    }
}