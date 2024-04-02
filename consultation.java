import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultation {
	
	private String date ;
	private int id_consultation;
	private int id_patient;
	 
	//getters and setters
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId_consultation() {
		return id_consultation;
	}

	public void setId_consultation(int id_consultation) {
		this.id_consultation = id_consultation;
	}

	public int getId_patient() {
		return id_patient;
	}

	public void setId_patient(int id_patient) {
		this.id_patient = id_patient;
	}

	public Consultation(String date, int id_consultation,int id_patient){
        this.date = date;
        this.id_consultation = id_consultation;
        this.id_patient = id_patient;

    }
	
   void detailConsultation (){
    try {
        PreparedStatement pstmt = con.prepareStatement("SELECT date,id_consultation,id_patient,ordonnance FROM consultation");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            date = rs.getString("date");
            id_consultation = rs.getInt("id_consultation");
            id_patient = rs.getInt("id_patient");
            String ordonnance = rs.getString("ordonnance");
            System.out.println("Date: " + date + ", Consultation ID: " + id_consultation + ", Patient ID: " + id_patient + ", Ordonnance: " + ordonnance);
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
   }
}

//enregistrer certificat medicale
