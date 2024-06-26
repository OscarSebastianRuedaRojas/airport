package com.airport.Revision.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.Revision.application.port.out.RevisionRepositoryPort;
import com.airport.Revision.domain.Revision;

public class RevisionRepository implements RevisionRepositoryPort {

    private String url;
    private String username;
    private String password;

    public RevisionRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public Revision save(Revision revision) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO revisions (revision_date, plane_id) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, java.sql.Date.valueOf(revision.getRevisionDate()));
            preparedStatement.setLong(2, revision.getPlaneId());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                revision.setId(rs.getLong(1));
            }

            return revision;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Revision findById(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM revisions WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Revision revision = new Revision();
                revision.setId(resultSet.getLong("id"));
                revision.setRevisionDate(resultSet.getDate("revision_date").toLocalDate());
                revision.setPlaneId(resultSet.getLong("plane_id"));
                return revision;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Revision> findAll() {
        List<Revision> revisions = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM revisions";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Revision revision = new Revision();
                revision.setId(resultSet.getLong("id"));
                revision.setRevisionDate(resultSet.getDate("revision_date").toLocalDate());
                revision.setPlaneId(resultSet.getLong("plane_id"));
                revisions.add(revision);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return revisions;
    }

    @Override
    public void update(Revision revision) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE revisions SET revision_date = ?, plane_id = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, java.sql.Date.valueOf(revision.getRevisionDate()));
            preparedStatement.setLong(2, revision.getPlaneId());
            preparedStatement.setLong(3, revision.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM revisions WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
