package com.airport.City.application.port.out;

import java.util.List;
import com.airport.City.domain.City;

/**
 * CityRepositoryPort
 */
public interface CityRepositoryPort {

    City save(City City);
    List <City> findAll();
}