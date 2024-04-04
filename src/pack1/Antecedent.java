package com.pooproject;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.sql.Connection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;



@Service
public class Antecedent {
    
	    @Autowired
    private Connection connection;

    @Autowired
    private ObjectMapper objectMapper;


    public void sauvegarderAntecedent(String antecedentMedicaux,String antecedentChirurgicaux ,String last_name) throws SQLException, IOException {
        String sql2 = "SELECT id_patient FROM patient WHERE last_name = ?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setString(1, last_name);
        ResultSet resultSet = preparedStatement2.executeQuery();
        if (resultSet.next()) {
            int idPatient = resultSet.getInt("id_patient");

            // Insert data into the antecedent table
            String sql = "INSERT INTO antecedent (antecedentMedicaux,antecedentChirurgicaux, id_patient) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, antecedentMedicaux);
            preparedStatement.setString(2, antecedentChirurgicaux);
            preparedStatement.setInt(3, idPatient);
            preparedStatement.executeUpdate();

            // Serialize antecedent object to JSON
            ObjectNode jsonData = objectMapper.createObjectNode();
            jsonData.put("antecedentMedicaux", antecedentMedicaux);
            jsonData.put("antecedentChirurgicaux", antecedentChirurgicaux);
            jsonData.put("id_patient", idPatient);

            // Write JSON data to the file
            File file = new File("antecedent.json");
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
