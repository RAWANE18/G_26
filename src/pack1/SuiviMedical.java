package pack1;

import java.util.List;

public class SuiviMedical {
	 
	 private FichePatient fichePatient;
	 private List<Consultation> consultations;
	 
		public SuiviMedical(FichePatient fichePatient, List<Consultation> consultations) {
			this.fichePatient = fichePatient;
			this.consultations = consultations;
	        
	    }
		//getteur
		public FichePatient getFichePatient() {
			return fichePatient;
		}
	
		public List<Consultation> getConsultations() {
			return consultations;
		}
		
		//Ajouter une consultation au suivi médical.
	    public void ajouterConsultation(Consultation consultation) {
	        consultations.add(consultation);
	    }
	    

		
}
