package com.melimed.cabinet.dtos;


public class AntecedantDTO {
    private Long idAntecedant;
    private String antecedantMedicaux;
    private String antecedantChirurgicaux;
    private Long patientId; // Assuming you only need the patient's ID in the DTO

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

