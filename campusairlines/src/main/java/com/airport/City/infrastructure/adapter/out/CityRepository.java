package com.airport.City.infrastructure.adapter.out;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.airport.City.application.port.out.CityRepositoryPort;
import com.airport.City.domain.City;

/**
 * CityRepository
 */
public class CityRepository implements CityRepositoryPort {
    private String url;
    private String username;
    private String password;
    public CityRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }
    @Override
    public List<City> findAll() {
        List<City> cityList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String query = "SELECT id, city_name, country_id from city";
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            while (resultset.next()) {
                City newCity = new City();
                newCity.setId(resultset.getString("id"));
                newCity.setName(resultset.getString("city_name"));
                newCity.setCountryId(resultset.getString("country_id"));
                cityList.add(newCity);
            }
            return cityList;
        } catch (Exception e) {
            System.out.println("Error al recuperar el listado de las ciudades.");
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public City save(City city) {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String query = "INSERT INTO city VALUES (?,?,?)";
            PreparedStatement statament = connection.prepareStatement(query);
            statament.setString(1, city.getId());
            statament.setString(2, city.getName());
            statament.setString(3, city.getCountryId());
            statament.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al guardar la ciudad en la base de datos");
            e.printStackTrace();
        }
        return null;
    }

}