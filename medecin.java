import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class medecin extends Personne{
	private String specialite ;
    private patient patient;
	

	//constructeur
	medecin(String nom, String prenom, String numTel, String specialite) {
		super(nom,prenom,numTel);
		this.specialite = specialite;
	}
	
    // get specialite
    
	public String getSpecialite() {
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT specialite FROM medecin");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                specialite = rs.getString("specialite");
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return specialite;
    }

    //ajouter une ordonnace
    public void ajouterOrdonnance(Patient patient) throws SQLException {
        String sql = "INSERT INTO ordonnance(id_patient, date_ordonnance, ordonnance) VALUES (?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, patient.getId()); 
        pstmt.setString(2, patient.getDateOrdonnance()); 
        pstmt.setString(3, patient.getOrdonnance());
    }
    
    
	
}
