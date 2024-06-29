package com.airport.CustomerPayment.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.CustomerPayment.application.port.out.CustomerPaymentRepositoryPort;
import com.airport.CustomerPayment.domain.CustomerPayment;


public class CustomerPaymentRepository implements CustomerPaymentRepositoryPort {

    private String url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
    private String username = "root";
    private String password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";

    public CustomerPayment save(CustomerPayment customerPayment) {
        String query = "INSERT INTO customer_payment (customer_id, payment_method_id, card_number, card_holder_name, card_expiry_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, customerPayment.getCustomerId());
            preparedStatement.setInt(2, customerPayment.getPaymentMethodId());
            preparedStatement.setString(3, customerPayment.getCardNumber());
            preparedStatement.setString(4, customerPayment.getCardHolderName());
            preparedStatement.setDate(5, new java.sql.Date(customerPayment.getCardExpiryDate().getTime()));

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                customerPayment.setId(rs.getInt(1));
            }
            return customerPayment;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CustomerPayment> findAll() {
        List<CustomerPayment> customerPayments = new ArrayList<>();
        String query = "SELECT * FROM customer_payment";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                CustomerPayment customerPayment = new CustomerPayment();
                customerPayment.setId(resultSet.getInt("id"));
                customerPayment.setCustomerId(resultSet.getString("customer_id"));
                customerPayment.setPaymentMethodId(resultSet.getInt("payment_method_id"));
                customerPayment.setCardNumber(resultSet.getString("card_number"));
                customerPayment.setCardHolderName(resultSet.getString("card_holder_name"));
                customerPayment.setCardExpiryDate(resultSet.getDate("card_expiry_date"));
                customerPayments.add(customerPayment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerPayments;
    }

    public CustomerPayment findById(int id) {
        String query = "SELECT * FROM customer_payment WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CustomerPayment customerPayment = new CustomerPayment();
                customerPayment.setId(resultSet.getInt("id"));
                customerPayment.setCustomerId(resultSet.getString("customer_id"));
                customerPayment.setPaymentMethodId(resultSet.getInt("payment_method_id"));
                customerPayment.setCardNumber(resultSet.getString("card_number"));
                customerPayment.setCardHolderName(resultSet.getString("card_holder_name"));
                customerPayment.setCardExpiryDate(resultSet.getDate("card_expiry_date"));
                return customerPayment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        String query = "DELETE FROM customer_payment WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(CustomerPayment customerPayment, int id) {
        String query = "UPDATE customer_payment SET customer_id = ?, payment_method_id = ?, card_number = ?, card_holder_name = ?, card_expiry_date = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customerPayment.getCustomerId());
            preparedStatement.setInt(2, customerPayment.getPaymentMethodId());
            preparedStatement.setString(3, customerPayment.getCardNumber());
            preparedStatement.setString(4, customerPayment.getCardHolderName());
            preparedStatement.setDate(5, new java.sql.Date(customerPayment.getCardExpiryDate().getTime()));
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
