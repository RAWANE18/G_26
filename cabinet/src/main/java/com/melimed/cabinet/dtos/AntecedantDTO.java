package com.melimed.cabinet.dtos;


public class AntecedantDTO {
    private Long idAntecedant;
    private String antecedantMedicaux;
    private String antecedantChirurgicaux;
    private String allergies;
    private String observation;
    private Long patientId; 

    // Constructors
    public AntecedantDTO() {
    }

    public AntecedantDTO(Long idAntecedant, String antecedantMedicaux, String antecedantChirurgicaux, Long patientId) {
        this.idAntecedant = idAntecedant;
        this.antecedantMedicaux = antecedantMedicaux;
        this.antecedantChirurgicaux = antecedantChirurgicaux;
        this.patientId = patientId;
    }

    // Getters and Setters
  
    public String getAllergies() {
        return allergies;
    }
    public String getObservation() {
        return observation;
    }
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
    public void setObservation(String observation) {
        this.observation = observation;
    }
    public Long getIdAntecedant() {
        return idAntecedant;
    }

    public void setIdAntecedant(Long idAntecedant) {
        this.idAntecedant = idAntecedant;
    }

    public String getAntecedantMedicaux() {
        return antecedantMedicaux;
    }

    public void setAntecedantMedicaux(String antecedantMedicaux) {
        this.antecedantMedicaux = antecedantMedicaux;
    }

    public String getAntecedantChirurgicaux() {
        return antecedantChirurgicaux;
    }

    public void setAntecedantChirurgicaux(String antecedantChirurgicaux) {
        this.antecedantChirurgicaux = antecedantChirurgicaux;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}

