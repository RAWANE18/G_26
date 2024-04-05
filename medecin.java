import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class medecin extends Personne{
	private String specialite ;
    private patient patient;
    private Consultation consultation;


	

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
     //ajouter un medecin 
     public void ajouterMedecin(String nom,String prenom,String numTel,String specialite){
        String sql = "INSERT INTO medecin(nom,prenom,numTel,specialite) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,nom);
        pstmt.setString(2,prenom);
        pstmt.setInt(3,numTel);
        pstmt.setString(4,specialite);

     }

    //ajouter une ordonnace
    public void ajouterOrdonnance(int id_patient,String date_ordonnance,String ordonnace) throws SQLException {
        String sql1 = "INSERT INTO ordonnance(id_patient, date_ordonnance, ordonnance) VALUES (?, ?, ?)";
        PreparedStatement pstmt1 = con.prepareStatement(sql1);
        pstmt1.setInt(1, id_patient); 
        pstmt1.setString(2, date_ordonnance); 
        pstmt1.setString(3, ordonnace);
    }
    
    
	//ajouter une consultation
    public void ajouterConsultation(String date,int id_consultation, int id_patient,String ordonnance) throws SQLException{
        string sql2 = "INSERT INTO consultation(date,id_consultation,id_patient,ordonnance) VALUES (?, ?, ?, ?)"
        PreparedStatement pstmt2 = con.prepareStatement(sql2);
        pstmt2.setString(1,date);
        pstmt2.setInt(2,id_consulatation);
        pstmt2.setInt(3,id_patient);
        pstmt2.setString(4,ordonnance);
    }

}
