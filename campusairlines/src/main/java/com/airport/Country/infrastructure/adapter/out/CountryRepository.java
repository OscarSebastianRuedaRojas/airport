package com.airport.Country.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.airport.Country.application.port.out.CountryRepositoryPort;
import com.airport.Country.domain.Country;

/**
 * CountryRepository
 */
public class CountryRepository implements CountryRepositoryPort{
    private String url;
    private String username;
    private String password;
    

    public CountryRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public Country findById(String id){
        Country newCountry = new Country();
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            String query = "SELECT id, country_name FROM countries WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                newCountry.setId(resultSet.getString("id"));
                newCountry.setCountryName(resultSet.getString("country_name"));
                return newCountry;
            } 
        } catch (Exception e) {
            System.out.println("Error al consultar la base de datos.");
            e.printStackTrace();
        }
        return newCountry;
    }

    @Override
    public Country findByName(String countryName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    public List<Country> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Country save(Country country) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void update(Long id, String newCountryName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    
}