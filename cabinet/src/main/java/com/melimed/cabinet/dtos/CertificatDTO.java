package com.melimed.cabinet.dtos;

import java.util.Date;

public class CertificatDTO {
    private Long idCertificat;
    private String contenu;
    private Date dateDelivrance;
    private Date dateExpiration;
    private Long patientId; 
    private String patientlastname;
    private String patientfirstname;
    private Long idconsultation;

    // Constructors
    public CertificatDTO() {
    }

    public CertificatDTO(Long idCertificat, String contenu,String patientfirstname ,String patientlastname, Date dateDelivrance, Date dateExpiration, Long patientId, Long idconsultation) {
        this.idCertificat = idCertificat;
        this.contenu = contenu;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.patientId = patientId;
        this.patientfirstname=patientfirstname;
        this.patientlastname=patientlastname;
        this.idconsultation=idconsultation;
    }

    // Getters and Setters
    public Long getIdCertificat() {
        return idCertificat;
    }

    public void setIdCertificat(Long idCertificat) {
        this.idCertificat = idCertificat;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public String getPatientfirstname() {
        return patientfirstname;
    }
    public String getPatientlastname() {
        return patientlastname;
    }

    public Date getDateDelivrance() {
        return dateDelivrance;
    }
    public Long getIdconsultation() {
        return idconsultation;
    }

    public void setIdconsultation(Long idconsultation) {
        this.idconsultation = idconsultation;
    }
    public void setDateDelivrance(Date dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
     public void setPatientfirstname(String patientfirstname) {
         this.patientfirstname = patientfirstname;
     }
     public void setPatientlastname(String patientlastname) {
         this.patientlastname = patientlastname;
     }
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
