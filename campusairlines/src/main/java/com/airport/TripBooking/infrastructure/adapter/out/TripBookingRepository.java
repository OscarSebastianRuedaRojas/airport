package com.airport.TripBooking.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.airport.TripBooking.application.port.out.TripBookingRepositoryPort;
import com.airport.TripBooking.domain.TripBooking;

/**
 * TripBookingRepository
 */
public class TripBookingRepository implements TripBookingRepositoryPort{

    private String url;
    private String username;
    private String password;

    

    public TripBookingRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public TripBooking save(TripBooking tripBooking) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO trip_booking (date, trip_id) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, tripBooking.getDate());
            preparedStatement.setLong(2, tripBooking.getTrip_id());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                tripBooking.setId(generatedKeys.getLong(1));
            }
            return tripBooking;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TripBooking findById(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT date, trip_id FROM trip_booking WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                TripBooking tripBooking = new TripBooking();
                tripBooking.setId(resultSet.getLong("id"));
                tripBooking.setDate(resultSet.getDate("date"));
                tripBooking.setTrip_id(resultSet.getLong("trip_id"));
                return tripBooking;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}