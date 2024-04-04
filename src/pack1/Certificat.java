package com.pooproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;

@Service
public class Certificat {

    @Autowired
    private Connection connection;

    @Autowired
    private ObjectMapper objectMapper;

    public void sauvegarderCertificat(String contenu, String last_name) throws SQLException, IOException {
        String sql2 = "SELECT id_patient FROM patient WHERE last_name = ?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setString(1, last_name);
        ResultSet resultSet = preparedStatement2.executeQuery();
        if (resultSet.next()) {
            int idPatient = resultSet.getInt("id_patient");

            // Calculate date_expiration
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, 3);
            Date dateExpiration = calendar.getTime();

            // Insert data into the certificats table
            String sql = "INSERT INTO certificats (contenu, date_delivrance, date_expiration, id_patient) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, contenu);
            preparedStatement.setDate(2, new java.sql.Date(new Date().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(dateExpiration.getTime()));
            preparedStatement.setInt(4, idPatient);
            preparedStatement.executeUpdate();

            // Serialize Certificat object to JSON
            ObjectNode jsonData = objectMapper.createObjectNode();
            jsonData.put("contenu", contenu);
            jsonData.put("date_delivrance", new Date().toString());
            jsonData.put("date_expiration", dateExpiration.toString());
            jsonData.put("id_patient", idPatient);

            // Write JSON data to the file
            File file = new File("certificats.json");
            if (file.exists()) {
                ObjectNode existingData = (ObjectNode) objectMapper.readTree(file);
                existingData.set("new_data", jsonData);
                objectMapper.writeValue(file, existingData);
            } else {
                objectMapper.writeValue(file, jsonData);
            }
        }
    }
}