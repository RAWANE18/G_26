package pack1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SuiviMedical {
      private List<FichePatient> fichesPatients;
	  private List<Consultation> consultations;
	  private List<Certificat> certificats;
	    
	   

		public SuiviMedical() {
	        this.fichesPatients = new ArrayList<>();
	        this.consultations = new ArrayList<>();
	        this.certificats = new ArrayList<>();
	        
	    }
		//Ajouter une certificat au suivi médica.
		public void ajouterFichePatient(FichePatient fichePatient) {
	        fichesPatients.add(fichePatient);
	    }
		//Ajouter une consultation au suivi médical.
	    public void ajouterConsultation(Consultation consultation) {
	        consultations.add(consultation);
	    }
	    //Ajouter une certificat au suivi médical.
	    public void ajouterCertificat(Certificat certificat) {
	        certificats.add(certificat);
	    }
	    
	    // Création d'un fichier qui contien les antécédents d'un patient .
	    public void ajouterAntecedent(String antecedent,int idPatient) {
	        String nomFichier = "patient" + idPatient + ".txt";
	        File file = new File(nomFichier);
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
	            writer.write(antecedent);
	            writer.newLine();
	           
	        } catch (IOException e) {
	            System.err.println("erreur : " + e.getMessage());
	        }
	    }
	    
	    public List<Certificat> getCertificats() {
	        return certificats;
	    }
	    public List<FichePatient> getFichesPatients() {
			return fichesPatients;
		}
		public List<Consultation> getConsultations() {
			return consultations;
		}

		
}
