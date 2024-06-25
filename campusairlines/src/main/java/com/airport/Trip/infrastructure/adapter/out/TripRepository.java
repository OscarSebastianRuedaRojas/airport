package com.airport.Trip.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import com.airport.Trip.application.port.out.TripRepositoryPort;
import com.airport.Trip.domain.Trip;

/**
 * TripRepository
 */
public class TripRepository implements TripRepositoryPort{

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
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public ArrayList<Trip> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Trip update(Trip trip, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Trip findById(Trip trip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    
}