package com.airport.Trip.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.Trip.application.port.out.TripRepositoryPort;
import com.airport.Trip.domain.Trip;

/**
 * TripRepository
 */
public class TripRepository implements TripRepositoryPort {

    private String url;
    private String username;
    private String password;

    public TripRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public Trip save(Trip trip) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO trips VALUES(NULL, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, trip.getTrip_date());
            preparedStatement.setFloat(2, trip.getPrice_trip());
            preparedStatement.setString(3, trip.getDeparture_city_id());
            preparedStatement.setString(4, trip.getDestination_city_id());
            preparedStatement.executeUpdate();
            return trip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Trip> findAll() {
        List<Trip> trips = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM trips";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Trip trip = new Trip();
                trip.setId(resultSet.getLong("id"));
                trip.setTrip_date(resultSet.getDate("trip_date"));
                trip.setPrice_trip(resultSet.getFloat("price_trip"));
                trip.setDeparture_city_id(resultSet.getString("departure_city_id"));
                trip.setDestination_city_id(resultSet.getString("destination_city_id"));
                trips.add(trip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trips;
    }

    @Override
    public Trip update(Trip trip, Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE trips SET trip_date = ?, price_trip = ?, departure_city_id = ?, destination_city_id = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, trip.getTrip_date());
            preparedStatement.setFloat(2, trip.getPrice_trip());
            preparedStatement.setString(3, trip.getDeparture_city_id());
            preparedStatement.setString(4, trip.getDestination_city_id());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
            return trip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM trips WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Trip findById(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM trip WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Trip trip = new Trip();
                trip.setId(resultSet.getLong("id"));
                trip.setTrip_date(resultSet.getDate("trip_date"));
                trip.setPrice_trip(resultSet.getFloat("price_trip"));
                trip.setDeparture_city_id(resultSet.getString("departure_city_id"));
                trip.setDestination_city_id(resultSet.getString("destination_city_id"));
                return trip;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}