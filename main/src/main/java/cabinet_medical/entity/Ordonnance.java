package cabinet_medical.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="ordonnances")
public class Ordonnance {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdonnance;
    //link with patient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "idPatient")
    private Patient patient;
    //link with la consutlation
    @ManyToOne
    @JoinColumn(name = "idConsultation")
    private Consultation consultation;
   
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;


    @Column(name = "contenu",columnDefinition = "TEXT")
    private String contenu;

   //setters and getters
   public void setContenu(String contenu) {
       this.contenu = contenu;
   }
   public void setPatient(Patient patient) {
       this.patient = patient;
   }
   public void setIdOrdonnance(Long idOrdonnance) {
       this.idOrdonnance = idOrdonnance;
   }
  
   public String getContenu() {
       return contenu;
   }
   public String getLastname() {
       return lastname;
   }
   public void setConsultation(Consultation consultation) {
    this.consultation = consultation;
}
public Consultaiton getConsultation() {
    return consultation;
   }
   public String getFirstname() {
       return firstname;
   }
   public Long getIdOrdonnance() {
       return idOrdonnance;
   }
   public Patient getPatient() {
       return patient;
   }



    //constructeur vide
public Ordonnance(){ /*constructeurs*/ }
    //Constructeur complet 
public Ordonnance(Patient patient, String contenu) {
    this.patient = patient;
    this.lastname = patient.getLastname();
    this.firstname = patient.getFirstname();
    this.contenu = contenu;
}
}
