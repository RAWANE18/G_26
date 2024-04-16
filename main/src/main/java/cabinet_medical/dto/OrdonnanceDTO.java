package cabinet_medical.dto;



public class OrdonnanceDTO {

    private Long idOrdonnance;
    private Long patientId;
    private Long fichePatientId;
    private String lastname;
    private String firstname;
    private String contenu;

    public OrdonnanceDTO() {
    }

    public OrdonnanceDTO(Long idOrdonnance, Long patientId, Long fichePatientId, String lastname, String firstname, String contenu) {
        this.idOrdonnance = idOrdonnance;
        this.patientId = patientId;
        this.fichePatientId = fichePatientId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.contenu = contenu;
    }

    public Long getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(Long idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
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
}
