package com.airport.Manufacture.application.port.in;

import java.util.List;

import com.airport.Manufacture.domain.Manufacture;


public interface IManufactureService {
    Manufacture createManufacture(Manufacture Manufacture);
    List<Manufacture> listManufacture();
}