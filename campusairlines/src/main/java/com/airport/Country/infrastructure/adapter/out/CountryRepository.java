package com.airport.Country.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
        Country newCountry = new Country();
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            String query = "SELECT id, country_name from countries WHERE LOWER(country_name) LiKE LOWER(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + countryName + "%");
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
    public List<Country> findAll() {
        List<Country> country = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String query = "SELECT id, country_name FROM Country"; 
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Country newCountry = new Country();
                newCountry.setId(resultSet.getString("id"));
                newCountry.setCountryName(resultSet.getString("country_name"));
                country.add(newCountry);
            }
            return country;
        } catch (Exception e) {
           e.printStackTrace();
        }
        return country;
    }

    @Override
    public Country save(Country country) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO countries VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getId());
            preparedStatement.setString(2, country.getCountryName());
            preparedStatement.executeUpdate();
            return country;
        } catch (Exception e) {
            System.out.println("Ocurrio un error al consultar la base de datos. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM countries WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id, String newCountryName) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE countries SET country?name = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(2, id);
            preparedStatement.setString(1, newCountryName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}