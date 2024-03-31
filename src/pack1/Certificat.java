package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Certificat {
    	private int idCertificat;
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
    
	public void sauvegarderCertificat(Connection connection) throws SQLException {
        String sql = "INSERT INTO certificats (contenu, date_delivrance, date_expiration, id_patient) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, contenu);
        preparedStatement.setDate(2, new java.sql.Date(dateDelivrance.getTime()));
        preparedStatement.setDate(3, new java.sql.Date(dateExpiration.getTime()));
        preparedStatement.setInt(4, idPatient);
        preparedStatement.executeUpdate();
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
