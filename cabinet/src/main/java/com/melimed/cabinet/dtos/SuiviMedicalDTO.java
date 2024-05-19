package com.melimed.cabinet.dtos;


public class SuiviMedicalDTO {
    private Long idSuivi;
    private Long patientId;
    private Long fichePatientId;

    // Constructors
    public SuiviMedicalDTO() {
    }

    public SuiviMedicalDTO(Long idSuivi, Long patientId, Long fichePatientId) {
        this.idSuivi = idSuivi;
        this.patientId = patientId;
        this.fichePatientId = fichePatientId;
    }

    // Getters and Setters
    public Long getIdSuivi() {
        return idSuivi;
    }

    public void setIdSuivi(Long idSuivi) {
        this.idSuivi = idSuivi;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getFichePatientId() {
        return fichePatientId;
    }

    public void setFichePatientId(Long fichePatientId) {
        this.fichePatientId = fichePatientId;
    }
}
