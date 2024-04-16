package cabinet_medical.dto;
import java.util.Date;

import cabinet_medical.entity.FichePatient;


public class FichePatientDTO {

    private Long idFichePatient;
    private String lastname;
    private String firstname;
    private String numTel;
    private Date birthdate;
    private String adresse;
    private String email;
    private String genre;
    private String groupeSanguin;
   
    public FichePatientDTO(FichePatient fichePatient) {
        this.idFichePatient = fichePatient.getIdFichepatient();
        this.lastname = fichePatient.getNom();
        this.firstname = fichePatient.getPrenom();
        this.numTel = fichePatient.getNumTel();
        this.birthdate = fichePatient.getDateNaissance();
        this.adresse = fichePatient.getAdresse();
        this.email = fichePatient.getEmail();
        this.genre = fichePatient.getGenre();
        this.groupeSanguin = fichePatient.getGroupeSanguin();
        
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }

    public String getAdresse() {
        return adresse;
    }
   public Date getBirthdate() {
       return birthdate;
   }
    public String getEmail() {
        return email;
    }
    public String getGenre() {
        return genre;
    }
    public String getGroupeSanguin() {
        return groupeSanguin;
    }
    public Long getIdFichePatient() {
        return idFichePatient;
    }
    public String getNumTel() {
        return numTel;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
   public void setBirthdate(Date birthdate) {
       this.birthdate = birthdate;
   }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }
    public void setIdFichePatient(Long idFichePatient) {
        this.idFichePatient = idFichePatient;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
}
