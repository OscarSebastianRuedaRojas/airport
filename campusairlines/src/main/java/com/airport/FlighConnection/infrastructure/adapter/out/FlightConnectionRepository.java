package com.airport.FlighConnection.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.FlighConnection.application.port.out.FlighConnectionRepositoryPort;
import com.airport.FlighConnection.domain.FlightConnection;

/**
 * FlighConnectionRepository
 */
public class FlightConnectionRepository implements FlighConnectionRepositoryPort{

    private String url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
    private String username = "root";
    private String password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";

    @Override
    public FlightConnection save(FlightConnection flightConnection) {
        String query = "INSERT INTO flight_connections (connection_number, trip_id, plane_id, airport_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, flightConnection.getConnection_number());
            preparedStatement.setLong(2, flightConnection.getTrip_id());
            preparedStatement.setLong(3, flightConnection.getPlane_id());
            preparedStatement.setString(4, flightConnection.getAirport_id());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                flightConnection.setId(rs.getLong(1));
            }
            return flightConnection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FlightConnection> findAll() {
        List<FlightConnection> flightConnections = new ArrayList<>();
        String query = "SELECT * FROM flight_connections";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                FlightConnection flightConnection = new FlightConnection();
                flightConnection.setId(resultSet.getLong("id"));
                flightConnection.setConnection_number(resultSet.getString("connection_number"));
                flightConnection.setTrip_id(resultSet.getLong("trip_id"));
                flightConnection.setPlane_id(resultSet.getLong("plane_id"));
                flightConnection.setAirport_id(resultSet.getString("airport_id"));
                flightConnections.add(flightConnection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightConnections;
    }

    @Override
    public FlightConnection findById(Long id) {
        String query = "SELECT * FROM flight_connections WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                FlightConnection flightConnection = new FlightConnection();
                flightConnection.setId(resultSet.getLong("id"));
                flightConnection.setConnection_number(resultSet.getString("connection_number"));
                flightConnection.setTrip_id(resultSet.getLong("trip_id"));
                flightConnection.setPlane_id(resultSet.getLong("plane_id"));
                flightConnection.setAirport_id(resultSet.getString("airport_id"));
                return flightConnection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM flight_connections WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FlightConnection update(FlightConnection flightConnection, Long id) {
        String query = "UPDATE flight_connections SET connection_number = ?, trip_id = ?, plane_id = ?, airport_id = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, flightConnection.getConnection_number());
            preparedStatement.setLong(2, flightConnection.getTrip_id());
            preparedStatement.setLong(3, flightConnection.getPlane_id());
            preparedStatement.setString(4, flightConnection.getAirport_id());
            preparedStatement.setLong(5, id);

            preparedStatement.executeUpdate();
            return flightConnection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}