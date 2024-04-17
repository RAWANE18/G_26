package cabinet_medical.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

@Entity
@Table(name="consultations")
@SecondaryTable(name="patients")
public class Consultation {
      
    private String date ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @column(name="idConsultation")
    private long idConsultation;
  
    @Column(table="patients")
    private int idPatient;
   //liste des ordonnances 
    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ordonnance> ordonnances = new ArrayList<>();

    //liste des certificats
    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificat> certificats = new ArrayList<>();
     
    //getters 
    public List<Ordonnance> getOrdonnances() {
        return ordonnances;
    public String getDate() {
        return date;
    }
    public Long getIdConsultation() {
        return idConsultation;
    }
    public int getIdPatient() {
    return idPatient;
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
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public List<Certificat> getCertificats() {
        return certificats;
    }

    //constructeurs
    public Consultation(){}

    public Consultation(String date, Long idconsultation,int idpatient){
        this.date = date;
        this.idConsultation = idconsultation;
        this.idPatient = idpatient;

    }
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
