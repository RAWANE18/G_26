package cabinet_medical.dto;


import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.*;
public class PatientDTO {
     private Long idPatient;
    @NotEmpty(message="entrez le nom")
    private String lastname;
    @NotEmpty(message="entrez le prenom")
    private String firstname;
    @NotEmpty(message="entrez le numero de telephone")
    private String numtel;
    @NotEmpty(message="veuillez saisir votre Email")
    private String email;
    @NotEmpty(message="choisissez votre genre")
    private String gender;
    @NotEmpty(message="entrez votre adress")
    private String adress;
    @NotEmpty(message="saisissez votre date de naissance")
    private Date birthdate;

    private List<Long> ordonnanceIds;

    public PatientDTO() {}

    public PatientDTO(Long idPatient, String firstname, String lastname, String numtel, String email, String gender, String adress, Date birthdate, List<Long> ordonnanceIds) {
        this.idPatient = idPatient;
        this.firstname = firstname;
        this.lastname = lastname;
        this.numtel = numtel;
        this.email = email;
        this.gender = gender;
        this.adress = adress;
        this.birthdate = birthdate;
        this.ordonnanceIds = ordonnanceIds;
    }

    // Getters and setters

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<Long> getOrdonnanceIds() {
        return ordonnanceIds;
    }

    public void setOrdonnanceIds(List<Long> ordonnanceIds) {
        this.ordonnanceIds = ordonnanceIds;
    }
}
