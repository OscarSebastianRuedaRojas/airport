package com.airport.Customer.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.Customer.application.port.out.CustomerRepositoryPort;
import com.airport.Customer.domain.Customer;

/**
 * CustomerRepository
 */
public class CustomerRepository implements CustomerRepositoryPort{

    private String url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
    private String username = "root";
    private String password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";

    @Override
    public Customer save(Customer customer) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO customer VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.getId());
            preparedStatement.setString(2, customer.getCustomer_name());
            preparedStatement.setInt(3, customer.getCustomer_age());
            preparedStatement.setLong(4, customer.getDocument_type_id());
            preparedStatement.executeUpdate();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer findById(String id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM customer WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getString("id"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_age(resultSet.getInt("customer_age"));
                customer.setDocument_type_id(resultSet.getLong("document_type_id"));
                return customer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM customer";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getString("id"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_age(resultSet.getInt("customer_age"));
                customer.setDocument_type_id(resultSet.getLong("document_type_id"));
                customers.add(customer);
            }
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void deleteCustomer(String id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM customer WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE customer SET customer_name = ?, customer_age = ?, document_type_id = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.getCustomer_name());
            preparedStatement.setInt(2, customer.getCustomer_age());
            preparedStatement.setLong(3, customer.getDocument_type_id());
            preparedStatement.setString(4, id);
            preparedStatement.executeUpdate();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}