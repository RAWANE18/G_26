package com.melimed.cabinet.dtos;

public class OrdonnanceDTO {
    private Long idOrdonnance;
    private String contenu;
    private Long patientId;
    private String patientlastname;
    private String patientfirstname;
    private Long  idconsultation;

    // Constructors
    public OrdonnanceDTO() {
    }

    public OrdonnanceDTO(Long  idconsultation,Long idOrdonnance, String contenu, Long patientId,String patientfirstname ,String patientlastname ) {
        this.idOrdonnance = idOrdonnance;
        this.contenu = contenu;
        this.patientId = patientId;
        this.patientfirstname=patientfirstname;
        this.patientlastname=patientlastname;
        this.idconsultation=idconsultation;
    }
    

    // Getters and Setters
    public Long getIdOrdonnance() {
        return idOrdonnance;
    }
    public String getPatientfirstname() {
        return patientfirstname;
    }
    public String getPatientlastname() {
        return patientlastname;
    }

    public void setIdOrdonnance(Long idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Long getPatientId() {
        return patientId;
    }
    public Long getIdconsultation() {
        return idconsultation;
    }
    public void setIdconsultation(Long idconsultation) {
        this.idconsultation = idconsultation;
    }
    public void setPatientfirstname(String patientfirstname) {
        this.patientfirstname = patientfirstname;
    }
    public void setPatientlastname(String patientlastname) {
        this.patientlastname = patientlastname;
    }
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
