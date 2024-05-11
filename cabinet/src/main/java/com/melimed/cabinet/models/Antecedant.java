package com.melimed.cabinet.models;


import jakarta.persistence.*;

@Entity
@Table(name = "antecedant")
public class Antecedant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedant;

    private String antecedantMedicaux;
    private String antecedantChirurgicaux;
    //Foreign Keys
    @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="patient" , referencedColumnName = "idPatient" )
      private  Patient patient;
    


  //constructeurs

  public Antecedant(){}
  public Antecedant(Long id, String antecedantchi , String antecedantmed){
    this.idAntecedant=id;
    this.antecedantChirurgicaux=antecedantchi;
    this.antecedantMedicaux=antecedantmed;
  }




    //getters
    public String getAntecedantChirurgicaux() {
        return antecedantChirurgicaux;
    }
    public String getAntecedantMedicaux() {
        return antecedantMedicaux;
    }
    public Long getIdAntecedant() {
        return idAntecedant;
    }
   public Patient getPatient() {
       return patient;
   }
    //setters
    public void setAntecedantChirurgicaux(String antecedantChirurgicaux) {
        this.antecedantChirurgicaux = antecedantChirurgicaux;
    }
    public void setAntecedantMedicaux(String antecedantMedicaux) {
        this.antecedantMedicaux = antecedantMedicaux;
    }
    public void setIdAntecedant(Long idAntecedant) {
        this.idAntecedant = idAntecedant;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
