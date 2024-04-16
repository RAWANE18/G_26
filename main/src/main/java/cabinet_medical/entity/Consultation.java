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
    private long idConsultation;
  
    @Column(table="patients")
    private int idPatient;
     
    //getters 
    public String getDate() {
        return date;
    }
    public Long getIdConsultation() {
        return idConsultation;
    }
    public int getIdPatient() {
    return idPatient;
    }

    //setters
    public void setIdConsultation(Long idConsultation) {
    this.idConsultation = idConsultation;
    }
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
    public void setDate(String date) {
        this.date = date;
    }


    //constructeurs
    public Consultation(){}

    public Consultation(String date, Long idconsultation,int idpatient){
        this.date = date;
        this.idConsultation = idconsultation;
        this.idPatient = idpatient;

    }
    

}
