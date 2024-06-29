package com.airport.PaymentMethods.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.airport.PaymentMethods.application.port.out.PaymentMethodsRepositoryPort;
import com.airport.PaymentMethods.domain.PaymentMethods;

/**
 * paymentMethodsRepository
 */
public class PaymentMethodsRepository implements PaymentMethodsRepositoryPort {
    private String url;
    private String username;
    private String password;

    public PaymentMethodsRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM payment_methods WHERE id = ? ";
        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<PaymentMethods> findAll() {
        List<PaymentMethods> paymentMethods = new ArrayList<>();
        String query = "SELECT * FROM payment_methods";
        try (Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                PaymentMethods paymentMethod = new PaymentMethods();
                paymentMethod.setId(resultSet.getInt("id"));
                paymentMethod.setMethodName(resultSet.getString("method_name"));
                paymentMethods.add(paymentMethod);
            }
            return paymentMethods;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PaymentMethods findById(int id) {
        String query = "SELECT * FROM payment_methods";
        try (Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query)) {
            if (rs.next()) {
                PaymentMethods paymentMethods = new PaymentMethods();
                paymentMethods.setId(rs.getInt("id"));
                paymentMethods.setMethodName(rs.getString("method_name"));
                return paymentMethods;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PaymentMethods save(PaymentMethods paymentMethods) {
        String query = "INSERT INTO payment_methods (method_name) VALUES (?)";
        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query,
                        Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(2, paymentMethods.getMethodName());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                paymentMethods.setId(rs.getInt("id"));
            }
            return paymentMethods;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(PaymentMethods paymentMethods) {
        String query = " UPDATE payment_methods SET method_name = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(2, paymentMethods.getId());
            preparedStatement.setString(1, paymentMethods.getMethodName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}