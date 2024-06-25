package com.airport.Country.application.port.in;

import java.util.List;
import com.airport.Country.domain.Country;

/**
 * ICountryService
 */
public interface ICountryService {
    Country createCountry(Country country);
    List<Country> listCountry();
    Country get(String id);
}
