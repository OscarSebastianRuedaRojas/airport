package com.airport.TripulationRol.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.airport.TripulationRol.application.port.out.TripulationRolRepositoryPort;
import com.airport.TripulationRol.domain.TripulationRol;



public class TripulationRolRepository implements TripulationRolRepositoryPort{
    private String url;
    private String username;
    private String password;
    
    

    public TripulationRolRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public TripulationRol save(TripulationRol tripulationRol) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO tripulation_roles VALUES(NULL, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tripulationRol.getRol_name());
            preparedStatement.executeUpdate();
            return tripulationRol;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tripulationRol;
    }

    @Override
    public List<TripulationRol> findAll() {
        ArrayList<TripulationRol> tripulation_roles = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT id, rol_name FROM tripulation_roles";
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            while (resultset.next()) {
                TripulationRol tripulationRol = new TripulationRol();
                tripulationRol.setId(resultset.getLong("id"));
                tripulationRol.setRol_name(resultset.getString("rol_name"));
                tripulation_roles.add(tripulationRol);
            }
            return tripulation_roles;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tripulation_roles;
    }

    
}