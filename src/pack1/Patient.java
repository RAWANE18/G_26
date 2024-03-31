package pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    	private int idPatient;
	private SuiviMedical suiviMedical;
	private Secretaire sectretaire;
	private Medcin medcin;
	private List<String> antecedents ;
//getteur setteur
	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	// Renvoie les antécédents médicaux du patient
	public List<String> getAntecedents() {
        return antecedents;
    }
	
	  //Ajoute un nouvel antécédent médical au patient. 
	public void ajouterAntecedentMedical(String antecedent) {
        suiviMedical.ajouterAntecedent(antecedent, idPatient);
    }
	
	//Charge les antécédents médicaux du patient depuis le fichier txt 
	
	  public List<String> chargerAntecedentsMedicaux(String nomFichier) throws IOException {
	        List<String> antecedents = new ArrayList<>();
	        
	        try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
	            String ligne;
	            while ((ligne = reader.readLine()) != null) {
	                antecedents.add(ligne);
	            }
	        }
	        
	        return antecedents;
	    }
	  
	public void demanderCertificat()
	{
		medcin.creationcertificat();
		
	}
	
	public void demandesupressionRDV()
	{	
		sectretaire.supressionRDV();
		
	}
}
