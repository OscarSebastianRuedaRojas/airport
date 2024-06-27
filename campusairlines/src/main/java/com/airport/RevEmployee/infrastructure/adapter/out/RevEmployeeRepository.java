package com.airport.RevEmployee.infrastructure.adapter.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airport.RevEmployee.application.port.out.RevEmployeeRepositoryPort;
import com.airport.RevEmployee.domain.RevEmployee;

public class RevEmployeeRepository implements RevEmployeeRepositoryPort{
    private String url;
    private String username;
    private String password;

    public RevEmployeeRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    public RevEmployee save(RevEmployee revEmployee) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO revemployee (idEmployee, idRevision) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, revEmployee.getIdEmployee());
            preparedStatement.setLong(2, revEmployee.getIdRevision());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                revEmployee.setId(generatedKeys.getLong(1));
            }
            return revEmployee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Optional<RevEmployee> findById(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM revemployee WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                RevEmployee revEmployee = new RevEmployee();
                revEmployee.setId(resultSet.getLong("id"));
                revEmployee.setIdEmployee(resultSet.getString("idEmployee"));
                revEmployee.setIdRevision(resultSet.getLong("idRevision"));
                return Optional.of(revEmployee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<RevEmployee> findAll() {
        List<RevEmployee> revEmployees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM revemployee";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                RevEmployee revEmployee = new RevEmployee();
                revEmployee.setId(resultSet.getLong("id"));
                revEmployee.setIdEmployee(resultSet.getString("idEmployee"));
                revEmployee.setIdRevision(resultSet.getLong("idRevision"));
                revEmployees.add(revEmployee);
            }
            return revEmployees;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return revEmployees;
    }

    public void deleteById(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM revemployee WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(RevEmployee revEmployee) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE revemployee SET idEmployee = ?, idRevision = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, revEmployee.getIdEmployee());
            preparedStatement.setLong(2, revEmployee.getIdRevision());
            preparedStatement.setLong(3, revEmployee.getId());
            preparedStatement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
