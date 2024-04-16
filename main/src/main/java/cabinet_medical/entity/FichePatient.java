package cabinet_medical.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "fiche_patient")
public class FichePatient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFichepatient;

    @Column(name = "date_naissance")
    private Date dateNaissance;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "email")
    private String email;

    @Column(name = "genre")
    private String genre;

    @Column(name = "groupe_sanguin")
    private String groupeSanguin;

        @Column(nullable = false)
        private String nom;
    
        @Column(nullable = false)
        private String prenom;
    
        @Column(nullable = false)
        private String numTel;
    
        @JsonIgnoreProperties("fichePatient")
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_patient")
        private Patient patient;
        //liste des ordonnances       
        @OneToMany(mappedBy = "fichePatient", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Ordonnance> ordonnances = new ArrayList<>();
    
        //liste des certificats
        @OneToMany(mappedBy = "fichePatient", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Certificat> certificats = new ArrayList<>();
        //l'antecedant 
        @OneToOne(mappedBy = "fichePatient", cascade = CascadeType.ALL)
         private Antecedant antecedant;

         @OneToOne(mappedBy = "suivimedical", cascade = CascadeType.ALL)
         private SuiviMedical suiviMedical ;
     
    //constructeurs    
    public FichePatient() {
    }

    public FichePatient(String nom, String prenom, String numTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
    }

    // Getters and setters
    public String getAdresse() {
        return adresse;
    }
    public List<Certificat> getCertificats() {
        return certificats;
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
    public Long getIdFichepatient() {
        return idFichepatient;
    }
    public String getNom() {
        return nom;
    }
    public String getNumTel() {
        return numTel;
    }
    public List<Ordonnance> getOrdonnances() {
        return ordonnances;
    }public Patient getPatient() {
        return patient;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getGenre() {
        return genre;
    }
   

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setCertificats(List<Certificat> certificats) {
        this.certificats = certificats;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }public void setEmail(String email) {
        this.email = email;
    }
    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }
    public void setIdFichepatient(Long idFichepatient) {
        this.idFichepatient = idFichepatient;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
    public void setOrdonnances(List<Ordonnance> ordonnances) {
        this.ordonnances = ordonnances;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setAntecedant(Antecedant antecedant) {
        this.antecedant = antecedant;
    }
 // rajouter/enlever antecedant de la fiche patient
    public void addAntecedant(Antecedant antecedant) {
        this.antecedant = antecedant;
        antecedant.setFichePatient(this);
    }

    public void removeAntecedant(Antecedant antecedant) {
        this.antecedant = null;
        antecedant.setFichePatient(null);
    }

    // rajouter/enlever ordonnance de la fiche patient
    public void addOrdonnance(Ordonnance ordonnance) {
        this.ordonnances.add(ordonnance);
        ordonnance.setFichePatient(this);
    }           
    public void removeOrdonnance(Ordonnance ordonnance) {
        this.ordonnances.remove(ordonnance);
        ordonnance.setFichePatient(null);
    }

    
     // rajouter/enlever certificat de la fiche patient
    public void addCertificat(Certificat certificat) {
        this.certificats.add(certificat);
        certificat.setFichePatient(this);
    }
    
    public void removeCertificat(Certificat certificat) {
        this.certificats.remove(certificat);
        certificat.setFichePatient(null);
    }

    public void setSuivimedical(SuiviMedical suiviMedical2) {
        this.suiviMedical=suiviMedical2;
    }
 
}
