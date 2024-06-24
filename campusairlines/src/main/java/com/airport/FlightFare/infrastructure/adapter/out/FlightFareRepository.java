package com.airport.FlightFare.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.airport.FlightFare.application.port.out.FlightFareRepositoryPort;
import com.airport.FlightFare.domain.FlightFare;

/**
 * FlightFareRepository
 */
public class FlightFareRepository implements FlightFareRepositoryPort {
    private String url;
    private String username;
    private String password;
    
    public FlightFareRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }
    @Override
    public FlightFare save(FlightFare flightFare) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO flight_fares VALUES (NULL, ? , ? ,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, flightFare.getDescription());
            preparedStatement.setString(2, flightFare.getDetails());
            preparedStatement.setDouble(3, flightFare.getValue());
            preparedStatement.executeUpdate();
            return flightFare;
        } catch (Exception e) {
            System.out.println("Ocurrio un error al consultar la base de datos. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FlightFare> findAll() {
        List<FlightFare> flightfares = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String query = "SELECT id, description, details, value FROM flight_fares"; 
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                FlightFare newFlightFare = new FlightFare();
                newFlightFare.setId(resultSet.getLong("id"));
                newFlightFare.setDescription(resultSet.getString("description"));
                newFlightFare.setDetails(resultSet.getString("details"));
                newFlightFare.setValue(resultSet.getDouble("details"));
                flightfares.add(newFlightFare);
            }
            return flightfares;
        } catch (Exception e) {
           e.printStackTrace();
        }
        return flightfares;
    }

    
}