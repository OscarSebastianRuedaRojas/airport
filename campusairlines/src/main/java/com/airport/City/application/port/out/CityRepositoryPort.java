package com.airport.City.application.port.out;

import java.util.List;
import com.airport.City.domain.City;

/**
 * CityRepositoryPort
 */
public interface CityRepositoryPort {
    City findById(String id);

    City save(City City);

    List<City> findAll();
}