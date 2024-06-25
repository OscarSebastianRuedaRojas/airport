package com.airport.Airport.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.airport.Airport.application.port.out.AirportRepositoryPort;
import com.airport.Airport.domain.Airport;

/**
 * AirportRepository
 */
public class AirportRepository implements AirportRepositoryPort {
    private String url;
    private String username;
    private String password;
    
    public AirportRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public List<Airport> findAll() {
        List<Airport> airportList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            String query = "SELECT air.id, air.airport_name, air.city_id , c.city_name FROM airport as air INNER JOIN city as c on air.city_id = c.id;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Airport newAirport = new Airport();
                newAirport.setId(resultSet.getString("id"));
                newAirport.setName(resultSet.getString("airport_name"));
                newAirport.setCityId(resultSet.getString("city_id"));
                airportList.add(newAirport);
            }
            return airportList;
        } catch (Exception e) {
            System.out.println("Error al recuperar el aeropuerto.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Airport save(Airport airport) {
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            String query = "INSERT INTO airport VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, airport.getId());
            preparedStatement.setString(2, airport.getName());
            preparedStatement.setString(3, airport.getCityId());
            preparedStatement.executeUpdate();
            return airport;
        } catch (Exception e) {
            System.out.println("Error al guardar el aeropuerto.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Airport findById(String id) {
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            String query = "SELECT id, airport_name, city_id FROM airport WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Airport newAirport = new Airport();
                newAirport.setId(resultSet.getString("id"));
                newAirport.setName(resultSet.getString("airport_name"));
                newAirport.setCityId(resultSet.getString("city_id"));
                return newAirport;
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar el aeropuerto.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Airport airport) {
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            String query = "UPDATE airport set airport_name = ?, city_id = ?  WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(3, airport.getId());
            preparedStatement.setString(1, airport.getName());
            preparedStatement.setString(2, airport.getCityId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar el aeropuerto.");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Airport airport) {
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            String query = "DELETE FROM airport WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, airport.getId());
            preparedStatement.executeUpdate();
            if (findById(airport.getId()) == null) {
                System.out.println("Se eleminio correctamente el aeropuerto " + airport.getName());
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el aeropuerto.");
            e.printStackTrace();
        }
    }

  
    
}