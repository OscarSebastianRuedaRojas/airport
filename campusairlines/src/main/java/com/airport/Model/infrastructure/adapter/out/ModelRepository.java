package com.airport.Model.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.airport.Model.application.port.out.ModelRepositoryPort;
import com.airport.Model.domain.Model;

/**
 * ModelRepository
 */
public class ModelRepository implements ModelRepositoryPort{

    private String url;
    private String username;
    private String password;

    
    public ModelRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public Model save(Model model) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO models VALUES (NULL, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setLong(2, model.getId_Manufacture());
            preparedStatement.executeUpdate();
            return model;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public ArrayList<Model> findAll() {
        ArrayList<Model> models = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT md.id AS id, md.name AS model, mf.name AS manufacture FROM models As md INNER JOIN manufactures AS mf ON md.manufacture_id = mf.id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Model model = new Model();
                model.setId(resultSet.getLong("id"));
                model.setName(resultSet.getString("model"));
                model.setName_Manufacture((resultSet.getString("manufacture")));
                models.add(model);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }

    
}