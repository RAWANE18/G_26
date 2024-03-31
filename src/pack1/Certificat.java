package pack1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
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
    
	public void sauvegarderCertificat(Connection connection) throws SQLException {
        String sql = "INSERT INTO certificats ( date_delivrance, date_expiration, id_patient) VALUES ( ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
      //  preparedStatement.setString(1, contenu);
        preparedStatement.setDate(1, new java.sql.Date(dateDelivrance.getTime()));
        preparedStatement.setDate(2, new java.sql.Date(dateExpiration.getTime()));
        preparedStatement.setInt(3, idPatient);
        preparedStatement.executeUpdate();
    }
	public void ajouterCertificat(String contenu,String delivrancedate,String expirationdate,int idCertificat,String Plastname,String Pfirstname) {
	        String nomFichier = "Certificat" + idCertificat + ".txt";
            String lastname ="Last Name: "+Plastname;
            String firstname="First Name: "+Pfirstname;
            String Date="delivrance date: "+delivrancedate;
            String EXP="expiration date: "+expirationdate;
            String style="------------------------------------------------------------------------------";
	        File file = new File(nomFichier);
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(style);
                writer.newLine();
                writer.write(Date);
                writer.newLine();
                writer.write(EXP);
                writer.newLine();
                writer.write(lastname);
                writer.newLine();
                writer.write(firstname);
                writer.newLine();
                writer.write(style);
                writer.newLine();
                writer.write(contenu);
                writer.newLine();
	           
	        } catch (IOException e) {
	            System.err.println("erreur : " + e.getMessage());
	        }
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
