package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Calendar;
public class Certificat {
    	//private int idCertificat;
    private String contenu;
    private Date dateDelivrance;
    private Date dateExpiration;
    private int idPatient;
    
    public Certificat(String contenu, Date dateDelivrance, Date dateExpiration,int idPatient) {
        this.contenu = contenu;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.idPatient = idPatient;
    }
    //Enregistre une certificat du patient en base de données. 
    
	public void sauvegarderCertificat(Connection connection ,String contenu,String last_name) throws SQLException {

        String sql2="SELECT id_patient FROM patient WHERE last_name =?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setString(1,last_name );
        ResultSet resultSet = preparedStatement2.executeQuery();
        idPatient = resultSet.getInt("id_patient");

        String sql = "INSERT INTO certificats (contenu, date_delivrance, date_expiration, id_patient) VALUES ( ?,?, ?, ?)";
        java.sql.Date datedelivrance=new java.sql.Date(dateDelivrance.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datedelivrance);

        // Adding 3 days to the current date
        calendar.add(Calendar.DAY_OF_MONTH, 3);

        // Converting back to java.sql.Date
        java.sql.Date datexpiration = new java.sql.Date(calendar.getTimeInMillis());
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, contenu);
        preparedStatement.setDate(2, datedelivrance);
        
        preparedStatement.setDate(3,datexpiration );
        preparedStatement.setInt(4, idPatient);
        
        preparedStatement.executeUpdate();
        ObjectMapper objectmapper = new ObjectMapper();
        String jsonData= objectMapper.writeValueAsString(new Certificat(contenu, dateDelivrance,dateExpiration, idPatient));
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    ObjectNode jsonData = objectMapper.createObjectNode();
    jsonData.put("contenu", contenu);
    jsonData.put("date_delivrance", new java.sql.Date(dateDelivrance.getTime()).toString());
    jsonData.put("date_expiration", new java.sql.Date(dateExpiration.getTime()).toString());
    jsonData.put("id_patient", idPatient);

    File file = new File("src/certificat.json");
    if (file.exists()) {
        // Append data to the existing JSON file
        JsonNode existingData = objectMapper.readTree(file);
        ((ObjectNode) existingData).put("new_data", jsonData);
        objectMapper.writeValue(file, existingData);
    } else {
        // Write data to a new JSON file
        objectMapper.writeValue(file, jsonData);
    }
    fileWriter.close(); 

    }
	
     //getteur et setteur
	
	public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(Date dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
