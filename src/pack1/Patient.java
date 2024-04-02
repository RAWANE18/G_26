package pack1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Patient extends Personne{
    private int idPatient;
	private SuiviMedical suiviMedical;
	private String email,gender,adress;
	private Date Birthdate;
	private Secretaire sectretaire;
	private Medcin medcin;
	

	public Patient(String firstname, String lastname, String phonenumber,String email,String gender,String adress,Date Birthdate,int idPatient)
	{
	super(firstname,lastname,phonenumber);
	this.email=email;
	this.gender=gender;
    this.Birthdate=Birthdate;
    this.idPatient=idPatient;
	}

//getteur setteur
	public int getIdPatient()
	{
		return idPatient;
	}

	public void setIdPatient(int idPatient) 
	{
		this.idPatient = idPatient;
	}
	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public String getAdress() 
	{
		return adress;
	}

	public void setAdress(String adress) 
	{
		this.adress = adress;
	}

	public Date getBirthdate() 
	{
		return Birthdate;
	}

	public void setBirthdate(Date birthdate) 
	{
		Birthdate = birthdate;
	}
	
	  public void demanderCertificat()
	{    
		medcin.creationcertificat();
		
	}
	public void demandeRDV()
	{	
		sectretaire.ajouterunRDV();
		
	}
	public void demandesupressionRDV()
	{	
		sectretaire.supressionRDV();
		
	}
}
