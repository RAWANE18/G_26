package cabinet_medical.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;
import jakarta.persistence.Table;
import java.util.Date;




@Entity
@Table(name="certificats")
@SecondaryTables(@SecondaryTable(name="patients"))
public class Certificat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCertificat;
    //link with patient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private Patient patient;
    //link with la consutlation
    @ManyToOne
    @JoinColumn(name = "idConsultation")
    private Consultation consultation;
   
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;


    @Column(name = "contenu")
    private String contenu;

    @Column(name = "date_delivrance")
    private Date dateDelivrance;

    @Column(name = "date_expiration")
    private Date dateExpiration;


    
   
//getters du certificat
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public void setDateDelivrance(Date dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }
    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
     public void setConsultation(Consultation consultation) {
         this.consultation = consultation;
     }
     public Consultation getConsultation() {
         return consultation;
     }
    //constructeur
    public Certificat(String contenu, Date dateDelivrance, Date dateExpiration, Patient patient) {
        this.contenu = contenu;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.patient = patient;
    }
//constructeur vide
    public Certificat() {}

   


}
