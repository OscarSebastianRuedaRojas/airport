package com.airport.User.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.airport.User.application.out.UserRepositoryPort;
import com.airport.User.domain.User;
import com.airport.User.domain.UserType;

public class UserRepository implements UserRepositoryPort{
    private String url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
    private String username = "root";
    private String password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";


    @Override
    public void save(User user) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO user (id, password, id_user_type) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getUserTypeId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(String id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT id, password, id_user_type FROM user WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setPassword(resultSet.getString("password"));
                user.setUserTypeId(resultSet.getInt("id_user_type"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserType> findAllUserTypes() {
        List<UserType> userTypes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT id, name FROM user_type";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserType userType = new UserType();
                userType.setId(resultSet.getInt("id"));
                userType.setName(resultSet.getString("name"));
                userTypes.add(userType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userTypes;
    }
}
