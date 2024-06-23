package com.airport.Country.application.port.in;

import java.util.List;
import com.airport.Country.domain.Country;

/**
 * ICountryService
 */
public interface ICountryService {
    Country createCountry(Country country);
    void updateCountry(String id, String newCountryName);
    void deleteCountry(String id);
    List<Country> listCountry();
    Country findCountryById(String id);
    Country findCountryByName(String countryName);
}
