package com.airport.RevisionDetail.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.RevisionDetail.application.port.out.RevisionDetailRepositoryPort;
import com.airport.RevisionDetail.domain.RevisionDetail;

public class RevisionDetailRepository implements RevisionDetailRepositoryPort{
    private String url;
    private String username;
    private String password;

    public RevisionDetailRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    public RevisionDetail save(RevisionDetail revisionDetail) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO revisions_details (description, revemployee_id) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, revisionDetail.getDescription());
            preparedStatement.setLong(2, revisionDetail.getRevemployeeId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                revisionDetail.setId(resultSet.getLong(1));
            }
            return revisionDetail;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<RevisionDetail> findAll() {
        List<RevisionDetail> revisionDetails = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM revisions_details";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                RevisionDetail revisionDetail = new RevisionDetail();
                revisionDetail.setId(resultSet.getLong("id"));
                revisionDetail.setDescription(resultSet.getString("description"));
                revisionDetail.setRevemployeeId(resultSet.getLong("revemployee_id"));
                revisionDetails.add(revisionDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return revisionDetails;
    }

    public RevisionDetail findById(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM revisions_details WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                RevisionDetail revisionDetail = new RevisionDetail();
                revisionDetail.setId(resultSet.getLong("id"));
                revisionDetail.setDescription(resultSet.getString("description"));
                revisionDetail.setRevemployeeId(resultSet.getLong("revemployee_id"));
                return revisionDetail;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM revisions_details WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RevisionDetail update(RevisionDetail revisionDetail) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE revisions_details SET description = ?, revemployee_id = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, revisionDetail.getDescription());
            preparedStatement.setLong(2, revisionDetail.getRevemployeeId());
            preparedStatement.setLong(3, revisionDetail.getId());
            preparedStatement.executeUpdate();
            return revisionDetail;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
