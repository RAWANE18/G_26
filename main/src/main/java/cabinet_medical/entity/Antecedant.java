package cabinet_medical.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Antecedant")
public class Antecedant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Antecedant_medicaux")
    private String AntecedantMedicaux;

    @Column(name = "Antecedant_chirurgicaux")
    private String AntecedantChirurgicaux;
    @Column(name = "contenu",columnDefinition = "TEXT")
    private String contenu;

  

    //lien avec le patient concerne
    @OneToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

   //link to fiche patient
   @OneToOne
    @JoinColumn(name = "fiche_patient_id")
    private FichePatient fichePatient;@Column(name = "contenu",columnDefinition = "TEXT")
    private String contenu;

   //setters and getters
   public void setContenu(String contenu) {
       this.contenu = contenu;
   }
   public String getContenu(){
    return contenu ;
   }

     set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAntecedantMedicaux() {
        return AntecedantMedicaux;
    }
    
    public void setAntecedantMedicaux(String antecedantMedicaux) {
        this.AntecedantMedicaux = antecedantMedicaux;
    }

    public String getAntecedantChirurgicaux() {
        return AntecedantChirurgicaux;
    }

    public void setAntecedantChirurgicaux(String antecedantChirurgicaux) {
        this.AntecedantChirurgicaux = antecedantChirurgicaux;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public void setFichePatient(FichePatient fichePatient) {
        this.fichePatient = fichePatient;
    }
    public FichePatient getFichePatient() {
        return fichePatient;
    }
    
}

