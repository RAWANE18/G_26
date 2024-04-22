package cabinet_medical.entity;



import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name="consultations")
@SecondaryTable(name="patients")
public class Consultation {
      
    private String date ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private long idConsultation;
  
   //liste des ordonnances 
    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ordonnance> ordonnances = new ArrayList<>();

    //liste des certificats
    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificat> certificats = new ArrayList<>();
     
    //lien au patient
    @JsonIgnoreProperties("consultaion")
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_patient")
        private Patient patient;
    //lien fiche patient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fichepatient")
    private FichePatient fichepatient;
     
    //getters 

    public Patient getPatient() {
        return patient;
    }
    public List<Ordonnance> getOrdonnances() {
        return ordonnances;}
    public String getDate() {
        return date;
    }
    public Long getIdConsultation() {
        return idConsultation;
    }
   
    public void setOrdonnances(List<Ordonnance> ordonnances) {
        this.ordonnances = ordonnances;
    }

    //setters
    public void setCertificats(List<Certificat> certificats) {
        this.certificats = certificats;
    }
    public void setIdConsultation(Long idConsultation) {
    this.idConsultation = idConsultation;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    public List<Certificat> getCertificats() {
        return certificats;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    //constructeurs
    public Consultation(){}

    public Consultation(String date, Long idconsultation,Patient patient){
        this.date = date;
        this.idConsultation = idconsultation;
        this.patient = patient;

    }
    //rajouter une ordonnance et la supprimer
    public void addOrdonnance(Ordonnance ordonnance) {
        this.ordonnances.add(ordonnance);
        ordonnance.setConsultation(this);
    }           
    public void removeOrdonnance(Ordonnance ordonnance) {
        this.ordonnances.remove(ordonnance);
        ordonnance.setConsultation(null);
    }

    
     // rajouter/enlever certificat de la consultation
    public void addCertificat(Certificat certificat) {
        this.certificats.add(certificat);
        certificat.setConsultation(this);
    }
    public void removeCertificat(Certificat certificat) {
        this.certificats.remove(certificat);
        certificat.setConsultation(null);
    }
    
    public void setFichePatient(FichePatient fichepatient) {
       this.fichepatient=fichepatient;
    }
   
}