package com.airport.Country.application.port.out;


import java.util.List;
import com.airport.Country.domain.Country;
/**
 * CountryRepositoryPort
 */
public interface CountryRepositoryPort {
    List<Country> findAll();
    Country save(Country country);
    Country findById(String id);

}
