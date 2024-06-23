package com.airport.Country.application.port.out;


import java.util.List;
import com.airport.Country.domain.Country;
/**
 * CountryRepositoryPort
 */
public interface CountryRepositoryPort {
    Country findById(String id); 
    Country findByName(String countryName);
    List<Country> findAll();
    Country save(Country country);
    void delete(Long id);
    void update(Long id, String newCountryName);
}
