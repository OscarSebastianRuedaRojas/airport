package com.airport;

import com.airport.Country.domain.Country;
import com.airport.Country.infrastructure.adapter.out.CountryRepository;

public class Main {
    public static void main(String[] args) {
        CountryRepository c = new CountryRepository();
        Country pais = c.findByName("argentina");
        System.out.println(pais.getCountryName());
    }
}