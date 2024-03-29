package pack1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class FichePatient {

    private String nom;
    private String prenom;
    private String numTel;
    private List<String> ordonnances;//liste des ordonnances du patient
    public int Id;
    public static int ID;
    private Date dateNaissance;
    private String email;
    private String sexe;
    private String groupeSanguin;
    private String adresse;
    
    public FichePatient(String nom, String prenom, String numTel) {
        ID++;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.Id=FichePatient.ID;
        this.ordonnances = new ArrayList<>();//a la creation du patient sa liste se cree
    }

    
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getNumTel() {
        return numTel;
    }
    public List<String> getOrdonnances() {
        return ordonnances;
    }
    public String getAdresse() {
        return adresse;
    }
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public String getEmail() {
        return email;
    }
    public String getGroupeSanguin() {
        return groupeSanguin;
    }
    public String getSexe() {
        return sexe;
    }
        
    
    //ajouter une ordonnance dans la liste
     public void ajouterOrdonnance(String clePrimaireOrdonnance) {
         this.ordonnances.add(clePrimaireOrdonnance);
    }
    


}
