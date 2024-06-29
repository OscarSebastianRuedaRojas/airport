package com.airport.Plane.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.Plane.application.port.out.PlaneRepositoryPort;
import com.airport.Plane.domain.Plane;

/**
 * PlaneRepository
 */
public class PlaneRepository implements PlaneRepositoryPort {
    private String url;
    private String username;
    private String password;

    public PlaneRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public Plane save(Plane plane) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO plane VALUES(NULL, ?, ?, ?, ?, ?, ? )";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, plane.getPlates());
            preparedStatement.setInt(2, plane.getCapacity());
            preparedStatement.setDate(3, plane.getFabrication_date());
            preparedStatement.setLong(4, plane.getStatus_id());
            preparedStatement.setLong(5, plane.getModel_id());
            preparedStatement.setLong(6, plane.getAirline_id());
            preparedStatement.executeUpdate();
            return plane;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Plane findById(String plates) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT p.id AS id, p.plates AS matricula, p.capacity AS capacity, p.fabrication_date AS fecha_fabricacion, s.status_name As estado, m.name as modelo, a.airline_name AS aerolinea FROM plane AS p INNER JOIN statuses as s ON p.status_id = s.id INNER JOIN models as m ON p.model_id = m.id  INNER JOIN airlines as a ON p.airline_id = a.id WHERE p.plates = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, plates);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Plane plane = new Plane();
                plane.setId(resultSet.getLong("id"));
                plane.setPlates(resultSet.getString("matricula"));
                plane.setCapacity(resultSet.getInt("capacity"));
                plane.setFabrication_date(resultSet.getDate("fecha_fabricacion"));
                plane.setStatus(resultSet.getString("estado"));
                plane.setAirline(resultSet.getString("aerolinea"));
                plane.setModel(resultSet.getString("modelo"));
                return plane;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Plane> findAll() {
        List<Plane> planes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT p.id AS id, p.plates AS matricula, p.capacity AS capacity, p.fabrication_date AS fecha_fabricacion, s.status_name As estado, m.name as modelo, a.airline_name AS aerolinea FROM plane AS p INNER JOIN statuses as s ON p.status_id = s.id INNER JOIN models as m ON p.model_id = m.id  INNER JOIN airlines as a ON p.airline_id = a.id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Plane plane = new Plane();
                plane.setId(resultSet.getLong("id"));
                plane.setPlates(resultSet.getString("matricula"));
                plane.setCapacity(resultSet.getInt("capacity"));
                plane.setFabrication_date(resultSet.getDate("fecha_fabricacion"));
                plane.setStatus(resultSet.getString("estado"));
                plane.setModel(resultSet.getString("aerolinea"));
                plane.setModel(resultSet.getString("modelo"));
                planes.add(plane);
            }
            return planes;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return planes;
    }

    @Override
    public void deletePlane(String plates) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM plane WHERE plates = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, plates);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Plane UpdatePlane(String plates, Plane plane) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE plane SET capacity = ?, fabrication_date = ?, status_id = ?, model_id = ?, airline_id = ? WHERE plates = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(6, plates);
            preparedStatement.setInt(1, plane.getCapacity());
            preparedStatement.setDate(2, plane.getFabrication_date());
            preparedStatement.setLong(3, plane.getStatus_id());
            preparedStatement.setLong(4, plane.getModel_id());
            preparedStatement.setLong(5, plane.getAirline_id());
            preparedStatement.executeUpdate();
            return plane;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}