package com.airport.TripCrew.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.TripCrew.application.port.out.TripCrewRepositoryPort;
import com.airport.TripCrew.domain.TripCrew;

/**
 * TripCrewRepository
 */
public class TripCrewRepository implements TripCrewRepositoryPort{

    private String url;
    private String username;
    private String password;

    public TripCrewRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public TripCrew save(TripCrew tripCrew) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO trip_crews (employees_id, connection_id) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tripCrew.getEmployee_id());
            preparedStatement.setLong(2, tripCrew.getConnection_id());
            preparedStatement.executeUpdate();
            return tripCrew;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TripCrew findById(String employeeId, Long connectionId) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM trip_crews WHERE employees_id = ? AND connection_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employeeId);
            preparedStatement.setLong(2, connectionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                TripCrew tripCrew = new TripCrew();
                tripCrew.setEmployee_id(resultSet.getString("employees_id"));
                tripCrew.setConnection_id(resultSet.getLong("connection_id"));
                return tripCrew;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TripCrew> findAll() {
        List<TripCrew> tripCrews = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM trip_crews";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                TripCrew tripCrew = new TripCrew();
                tripCrew.setEmployee_id(resultSet.getString("employees_id"));
                tripCrew.setConnection_id(resultSet.getLong("connection_id"));
                tripCrews.add(tripCrew);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tripCrews;
    }
}