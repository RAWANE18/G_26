package pack1;

import java.util.ArrayList;
import java.util.List;

public class DossierMedical {
    private List<Patient> patient;
	    private List<SuiviMedical> suivi;

	    public DossierMedical() {
	        this.patient = new ArrayList<>();
	        this.suivi = new ArrayList<>();
	    }
	    //Ajoute un suivi médical pour un patient
	    public void ajouterSuiviMedical(Patient patient, SuiviMedical suivi) {
	       this.patient.add(patient);
	        this.suivi.add(suivi);
	    }
	    //Renvoie le suivi médical d'un patient.
	    public SuiviMedical getSuiviMedical(Patient patient) {
	        for (int i = 0; i < this.patient.size(); i++) {
	        	//si patient trouvé retourner sont suivi
	            if (this.patient.get(i).equals(patient)) {
	                return this.suivi.get(i);
	            }
	        }
	        return null; 
	    } 
}
