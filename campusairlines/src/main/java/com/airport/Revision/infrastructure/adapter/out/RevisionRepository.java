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
import com.airport.Revision.domain.RevisionDTO;

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
            System.out.println("Error: No se pueden eliminar revisiones asignadas a un empleado.");
            e.printStackTrace();
        }
    }
    @Override
    public List<RevisionDTO> findByPlanePlate(String plate) {
        List<RevisionDTO> planeRevision = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT revem.id AS revemployee_id, e.employee_name, e.rol_id, e.admission_date, e.airline_id, e.airport_id, " +
                           "red.description, r.id AS revision_id, r.revision_date, r.plane_id, " +
                           "p.plates, p.capacity, p.fabrication_date, p.status_id, p.model_id " +
                           "FROM revemployee AS revem " +
                           "INNER JOIN employees e ON revem.id_employee = e.id " +
                           "INNER JOIN revisions_details red ON revem.id = red.revemployee_id " +
                           "INNER JOIN revisions r ON revem.id_revision = r.id " +
                           "INNER JOIN plane p ON r.plane_id = p.id " +
                           "WHERE p.plates = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, plate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RevisionDTO revisionDTO = new RevisionDTO();
                revisionDTO.setId(resultSet.getLong("revemployee_id"));
                revisionDTO.setEmployeeName(resultSet.getString("employee_name"));
                revisionDTO.setRolId(resultSet.getInt("rol_id"));
                revisionDTO.setAdmissionDate(resultSet.getDate("admission_date").toLocalDate());
                revisionDTO.setAirlineId(resultSet.getInt("airline_id"));
                revisionDTO.setAirportId(resultSet.getString("airport_id"));
                revisionDTO.setDescription(resultSet.getString("description"));
                revisionDTO.setRevisionDate(resultSet.getDate("revision_date").toLocalDate());
                revisionDTO.setPlaneId(resultSet.getLong("plane_id"));
                revisionDTO.setPlates(resultSet.getString("plates"));
                revisionDTO.setCapacity(resultSet.getInt("capacity"));
                revisionDTO.setFabricationDate(resultSet.getDate("fabrication_date").toLocalDate());
                revisionDTO.setStatusId(resultSet.getInt("status_id"));
                revisionDTO.setModelId(resultSet.getInt("model_id"));
                planeRevision.add(revisionDTO);
            }
            return planeRevision;
        } catch (Exception e) {
            System.out.println("Error al consultar revisiones por matricula de avion");
            e.printStackTrace();
        }
        return null;
    }
}
