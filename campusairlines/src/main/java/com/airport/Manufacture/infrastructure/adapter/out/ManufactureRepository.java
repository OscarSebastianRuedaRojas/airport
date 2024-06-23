package com.airport.Manufacture.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.Manufacture.application.port.out.ManufactureRepositoryPort;
import com.airport.Manufacture.domain.Manufacture;

public class ManufactureRepository implements ManufactureRepositoryPort{
    private String url;
    private String username;
    private String password;

    public ManufactureRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public List<Manufacture> findAll() {
        List<Manufacture> manufactures = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String query = " SELECT id, name FROM manufactures";
            Statement statement =connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Manufacture manufacture = new Manufacture();
                manufacture.setId(resultSet.getLong("id"));
                manufacture.setManufacture_name(resultSet.getString("name"));
                manufactures.add(manufacture);
            }
            return manufactures;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manufactures;
    }

    @Override
    public Manufacture findById(Long id) {
        Manufacture manufacture = new Manufacture();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT id, name FROM manufactures WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                manufacture.setId(resultSet.getLong("id"));
                manufacture.setManufacture_name(resultSet.getString("name"));
                return manufacture;
            } else {
                System.out.println(String.format("No hay empresa con el id %l ", id));
                return manufacture;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manufacture;
    }

    @Override
    public Manufacture findByName(String manufactureName) {
        Manufacture manufacture = new Manufacture();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT id, name FROM manufactures WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(0, manufactureName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                manufacture.setId(resultSet.getLong("id"));
                manufacture.setManufacture_name(resultSet.getString("name"));
                return manufacture;
            } else {
                System.out.println(String.format("No hay empresa con el nombre: %s", manufactureName));
                return manufacture;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manufacture;
    }

    

    @Override
    public Manufacture save(Manufacture manufacture) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO manufactures VALUES (NULL, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, manufacture.getManufacture_name());
            preparedStatement.executeUpdate();
            return manufacture;
        } catch (Exception e) {
            System.out.println("Ocurrio un error al consultar la base de datos");
            e.printStackTrace();
        }
        return manufacture;
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM manufactures WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, String newmanufactureName) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE manufactures SET name = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newmanufactureName);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}