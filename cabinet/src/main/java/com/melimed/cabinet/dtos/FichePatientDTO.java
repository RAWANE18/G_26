package com.melimed.cabinet.dtos;


import java.util.List;

public class FichePatientDTO {
    private Long idFichePatient;
    private PatientDTO patient;
    private List<ConsultationDTO> consultations;

    // Constructors
    public FichePatientDTO() {
    }

    public FichePatientDTO(Long idFichePatient, PatientDTO patient, List<ConsultationDTO> consultations) {
        this.idFichePatient = idFichePatient;
        this.patient = patient;
        this.consultations = consultations;
    }

    // Getters and Setters
    public Long getIdFichePatient() {
        return idFichePatient;
    }

    public void setIdFichePatient(Long idFichePatient) {
        this.idFichePatient = idFichePatient;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public List<ConsultationDTO> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<ConsultationDTO> consultations) {
        this.consultations = consultations;
    }

    public void addConsultation(ConsultationDTO consultation) {
        this.consultations.add(consultation);
    }
}
