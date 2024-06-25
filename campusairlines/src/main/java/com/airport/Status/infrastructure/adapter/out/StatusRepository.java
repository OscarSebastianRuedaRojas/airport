package com.airport.Status.infrastructure.adapter.out;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.airport.Status.application.port.out.StatusRepositoryPort;
import com.airport.Status.domain.Status;

public class StatusRepository implements StatusRepositoryPort{

    private String url;
    private String username;
    private String password;

    
    public StatusRepository() {
        
    }

    @Override
    public Status save(Status status) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO statuses VALUES(NULL, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, status.getName());
            preparedStatement.executeUpdate();
            return status;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Status> findAll() {
        List<Status> statuses = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT id, status_name FROM statuses";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getLong("id"));
                status.setName(resultSet.getString("status_name"));
                statuses.add(status);
            }
            return statuses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statuses;
    }

    
}