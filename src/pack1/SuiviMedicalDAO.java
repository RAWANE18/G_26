package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuiviMedicalDAO {
   	//Enregistre le suivi medical du patient en base de données avec une certificat. 
	public void sauvegarderSuiviMedical(Connection connection, int idCertificat, int idConsultation, int idFichePatient) throws SQLException {
	    String sql = "INSERT INTO suivis_medicaux (id_certificat, id_consultation, id_fichpatient) VALUES (?, ?, ?)";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    
	    preparedStatement.setInt(1, idCertificat);
	    preparedStatement.setInt(2, idConsultation);
	    preparedStatement.setInt(3, idFichePatient);
	        
	    preparedStatement.executeUpdate();
	}
	//Enregistre le suivi medical du patient en base de données sans certificat. 
	public void sauvegarderSuiviMedical(Connection connection, int idConsultation, int idFichePatient) throws SQLException {
	    String sql = "INSERT INTO suivis_medicaux ( id_consultation, id_fichpatient) VALUES (?, ?)";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    
	    preparedStatement.setInt(1, idConsultation);
	    preparedStatement.setInt(2, idFichePatient);
	        
	    preparedStatement.executeUpdate(); 
}
