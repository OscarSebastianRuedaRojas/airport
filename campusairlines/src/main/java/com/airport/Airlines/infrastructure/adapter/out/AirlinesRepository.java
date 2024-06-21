package com.airport.Airlines.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.Airlines.application.port.out.AirlinesRepositoryPort;
import com.airport.Airlines.domain.Airlines;

/**
 * AirlinesRepository
 */
public class AirlinesRepository implements AirlinesRepositoryPort {
    private String url;
    private String username;
    private String password;
    
    public AirlinesRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public List <Airlines> findAll() {
        List<Airlines> airlines = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String query = "SELECT id, airline_name FROM airlines"; 
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Airlines newAirlines = new Airlines();
                newAirlines.setId(resultSet.getLong("id"));
                newAirlines.setairline_name(resultSet.getString("airline_name"));
                airlines.add(newAirlines);
            }
            return airlines;
        } catch (Exception e) {
           e.printStackTrace();
        }
        return airlines;
    }

    @Override
    public Airlines findById(Long id) {
        Airlines newAirline = new Airlines();
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String query = "SELECT id, airline_name FROM airlines WHERE id = ?"; 
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(); // no se debe pasar ya que prepared statment ya preparo la consulta
            if (resultSet.next()) {
                newAirline.setId(resultSet.getLong("id"));
                newAirline.setairline_name(resultSet.getString("airline_name"));
                return newAirline;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}