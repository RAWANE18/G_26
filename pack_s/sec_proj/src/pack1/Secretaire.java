package pack1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Secretaire extends Personne{
   
    FichePatient fichePatient;
  public void remplirFichePatient(String nom, String prenom, String numTel) {
    // Récupérer les informations du patient à partir de la base de données
    String sql = "SELECT * FROM patients WHERE nom = ? AND prenom = ? tel = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, nom);
    preparedStatement.setString(2, prenom);
    preparedStatement.setString(3, numTel);
  
    ResultSet resultSet = preparedStatement.executeQuery();

    // Si le patient est trouvé, remplir la fiche patient avec les informations récupérées
    if (resultSet.next()) {
        String nomPatient = resultSet.getString("nom");
        String prenomPatient = resultSet.getString("prenom");
        String numTelPatient = resultSet.getString("numTel");
        
        
        //rajouter un lien vers une liste des ordonnances
        //rajouter un lien vers les elements du dossier medical
        

        // Remplir la fiche patient avec les informations récupérées
         fichePatient = new FichePatient(nomPatient, prenomPatient, numTelPatient);
    }


        //elle recoit les inormations et puis les 
    
            FichePatientDAO fichePatientDAO = new FichePatientDAO();
            fichePatientDAO.insertFichePatient(fichePatient);
        }
    
    
        private RendezVousDAO rendezVousDAO;

        public Secretaire(RendezVousDAO rendezVousDAO) {
            this.rendezVousDAO = rendezVousDAO;
        }
    
        public void gererDemandeRendezVous(String nomPatient, String prenomPatient, String date, String heure) {
            RendezVous nouveauRendezVous = new RendezVous();
            nouveauRendezVous.setNomPatient(nomPatient);
            nouveauRendezVous.setPrenomPatient(prenomPatient);
            nouveauRendezVous.setDate(date);
            nouveauRendezVous.setHeure(heure);
    
            if (rendezVousDAO.verifierDisponibilite(date, heure)) {
                rendezVousDAO.enregistrerRendezVous(nouveauRendezVous);
                System.out.println("Rendez-vous enregistré avec succès.");
            } else {
                System.out.println("Le rendez-vous n'est pas disponible à cette date et heure.");
            }
        }
}
