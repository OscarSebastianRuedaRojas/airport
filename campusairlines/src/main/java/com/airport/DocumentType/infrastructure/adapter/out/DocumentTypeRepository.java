package com.airport.DocumentType.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airport.DocumentType.domain.DocumentType;
import com.airport.DocumentType.application.port.out.DocumentTypeRepositoryPort;

/**
 * DocumentTypeRepository
 */
public class DocumentTypeRepository implements DocumentTypeRepositoryPort {
    private String url;
    private String username;
    private String password;

    public DocumentTypeRepository() {
        this.url = "jdbc:mysql://viaduct.proxy.rlwy.net:47771/airport";
        this.username = "root";
        this.password = "uCbNeUCEUrEqhmfXPrWKkWtWDlaPAnrI";
    }

    @Override
    public List<DocumentType> findAll() {
        List<DocumentType> DocumentType = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT id_document_type, name FROM document_types";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                DocumentType newDocumentType = new DocumentType();
                newDocumentType.setId(resultSet.getLong("id_document_type"));
                newDocumentType.setName(resultSet.getString("name"));
                DocumentType.add(newDocumentType);
            }
            return DocumentType;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DocumentType;
    }

    @Override
    public DocumentType findById(Long id) {
        DocumentType newDocumentType = new DocumentType();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT id_document_type, name FROM document_types WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(); // no se debe pasar ya que prepared statment ya preparo la consulta
            if (resultSet.next()) {
                newDocumentType.setId(resultSet.getLong("id"));
                newDocumentType.setName(resultSet.getString("name"));
                return newDocumentType;
            } else {
                System.out.println("No hay tipo de documento con el id: " + id + ".");
                return newDocumentType;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DocumentType save(DocumentType documentType) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO document_types VALUES (NULL, ? )";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, documentType.getName());
            preparedStatement.executeUpdate();
            return documentType;
        } catch (Exception e) {
            System.out.println("Ocurrio un error al consultar la base de datos. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM document_types WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, String newTypeName) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE document_types SET name = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(2, id);
            preparedStatement.setString(1, newTypeName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DocumentType findByName(String typeName) {
        DocumentType newTypeName = new DocumentType();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT id, name from document_types WHERE LOWER(name) LiKE LOWER(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + typeName + "%");
            ResultSet resultSet = preparedStatement.executeQuery(); // no se debe pasar ya que prepared statment ya
                                                                    // preparo la consulta
            if (resultSet.next()) {
                newTypeName.setId(resultSet.getLong("id"));
                newTypeName.setName(resultSet.getString("name"));
                return newTypeName;
            } else {
                System.out.println("No hay tipo de documento con el nombre: " + typeName + ".");
                return newTypeName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newTypeName;
    }

}