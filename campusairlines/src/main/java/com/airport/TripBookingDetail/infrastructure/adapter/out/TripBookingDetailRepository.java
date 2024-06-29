package com.airport.TripBookingDetail.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.TripBookingDetail.application.port.out.TripBookingDetailRepositoryPort;
import com.airport.TripBookingDetail.domain.TripBookingDetail;

/**
 * TripBookingDetailRepository
 */
public class TripBookingDetailRepository implements TripBookingDetailRepositoryPort {

    private String url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
    private String username = "root";
    private String password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";

    @Override
    public TripBookingDetail save(TripBookingDetail tripBookingDetail) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO trip_booking_details (trip_booking_id, customer_id, fares_id, seat, customer_payment_id ) VALUES (?, ?, ?, ?, ? )";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, tripBookingDetail.getTripBookingId());
            preparedStatement.setString(2, tripBookingDetail.getCustomerId());
            preparedStatement.setInt(3, tripBookingDetail.getFaresId());
            preparedStatement.setString(4, tripBookingDetail.getSeat());
            preparedStatement.setInt(5, tripBookingDetail.getCustomerPaymentId());
            preparedStatement.executeUpdate();
            return tripBookingDetail;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TripBookingDetail findById(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM trip_booking_details WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                TripBookingDetail tripBookingDetail = new TripBookingDetail();
                tripBookingDetail.setId(resultSet.getLong("id"));
                tripBookingDetail.setTripBookingId(resultSet.getLong("trip_booking_id"));
                tripBookingDetail.setCustomerId(resultSet.getString("customer_id"));
                tripBookingDetail.setFaresId(resultSet.getInt("fares_id"));
                tripBookingDetail.setSeat(resultSet.getString("seat"));
                tripBookingDetail.setCustomerPaymentId(resultSet.getInt("customer_payment_id"));
                return tripBookingDetail;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TripBookingDetail> findAll() {
        List<TripBookingDetail> tripBookingDetails = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM trip_booking_details";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                TripBookingDetail tripBookingDetail = new TripBookingDetail();
                tripBookingDetail.setId(resultSet.getLong("id"));
                tripBookingDetail.setTripBookingId(resultSet.getLong("trip_booking_id"));
                tripBookingDetail.setCustomerId(resultSet.getString("customer_id"));
                tripBookingDetail.setFaresId(resultSet.getInt("fares_id"));
                tripBookingDetail.setSeat(resultSet.getString("seat"));
                tripBookingDetail.setCustomerPaymentId(resultSet.getInt("customer_payment_id"));
                tripBookingDetails.add(tripBookingDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tripBookingDetails;
    }

    @Override
    public void deleteById(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM trip_booking_details WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public TripBookingDetail update(Long id, TripBookingDetail tripBookingDetail) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE trip_booking_details SET customer_id = ?, fares_id = ?, seat = ?, customer_payment_id = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(5, tripBookingDetail.getTripBookingId());
            preparedStatement.setString(1, tripBookingDetail.getCustomerId());
            preparedStatement.setInt(2, tripBookingDetail.getFaresId());
            preparedStatement.setLong(4, id);
            preparedStatement.setString(3, tripBookingDetail.getSeat());
            preparedStatement.setInt(4, tripBookingDetail.getCustomerPaymentId());
            preparedStatement.executeUpdate();
            return tripBookingDetail;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}