package com.airport.Employee.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.Employee.application.port.out.EmployeeRepositoryPort;
import com.airport.Employee.domain.Employee;

/**
 * EmployeeRepository
 */
public class EmployeeRepository implements EmployeeRepositoryPort{

    private String url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
    private String username = "root";
    private String password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";

    @Override
    public Employee save(Employee employee) {
        String query = "INSERT INTO employees (id, employee_name, rol_id, admission_date, airline_id, airport_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, employee.getId());
            preparedStatement.setString(2, employee.getEmployee_name());
            preparedStatement.setLong(3, employee.getRol_id());
            preparedStatement.setDate(4, new java.sql.Date(employee.getAdmission_date().getTime()));
            preparedStatement.setLong(5, employee.getAirline_id());
            preparedStatement.setString(6, employee.getAirport_id());

            preparedStatement.executeUpdate();
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getString("id"));
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setRol_id(resultSet.getLong("rol_id"));
                employee.setAdmission_date(resultSet.getDate("admission_date"));
                employee.setAirline_id(resultSet.getLong("airline_id"));
                employee.setAirport_id(resultSet.getString("airport_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee findById(String id) {
        String query = "SELECT * FROM employees WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getString("id"));
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setRol_id(resultSet.getLong("rol_id"));
                employee.setAdmission_date(resultSet.getDate("admission_date"));
                employee.setAirline_id(resultSet.getLong("airline_id"));
                employee.setAirport_id(resultSet.getString("airport_id"));
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM employees WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee update(Employee employee, String id) {
        String query = "UPDATE employees SET employee_name = ?, rol_id = ?, admission_date = ?, airline_id = ?, airport_id = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setLong(2, employee.getRol_id());
            preparedStatement.setDate(3, new java.sql.Date(employee.getAdmission_date().getTime()));
            preparedStatement.setLong(4, employee.getAirline_id());
            preparedStatement.setString(5, employee.getAirport_id());
            preparedStatement.setString(6, id);

            preparedStatement.executeUpdate();
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}