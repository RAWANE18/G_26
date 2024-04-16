package cabinet_medical.dto;


import java.util.Date;

public class CertificatDTO {

    private Long idCertificat;
    private Long patientId;
    private Long fichePatientId;
    private String lastname;
    private String firstname;
    private String contenu;
    private Date dateDelivrance;
    private Date dateExpiration;

    public CertificatDTO() {}

    public CertificatDTO(Long idCertificat, Long patientId, Long fichePatientId, String lastname, String firstname, String contenu, Date dateDelivrance, Date dateExpiration) {
        this.idCertificat = idCertificat;
        this.patientId = patientId;
        this.fichePatientId = fichePatientId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.contenu = contenu;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
    }

    // Getters and setters

    public Long getIdCertificat() {
        return idCertificat;
    }

    public void setIdCertificat(Long idCertificat) {
        this.idCertificat = idCertificat;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateDelivrance() {
        return dateDelivrance;
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
}

