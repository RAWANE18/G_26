package cabinet_medical.dto;


public class SuiviMedicalDTO {
  
   

    
    private Long idsuivi;
    private String lastname;
    private String firstname;
    private String numtel;
    private FichePatientDTO fichePatient;
    
    public SuiviMedicalDTO() {
    // empty constructor
    }
    
    public SuiviMedicalDTO(Long idsuivi, String lastname, String firstname, String numtel, FichePatientDTO fichePatient) {
    this.idsuivi = idsuivi;
    this.lastname = lastname;
    this.firstname = firstname;
    this.numtel = numtel;
    this.fichePatient = fichePatient;
    }
    
    public Long getIdsuivi() {
    return idsuivi;
    }
    
    public void setIdsuivi(Long idsuivi) {
    this.idsuivi = idsuivi;
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
    
    public String getNumtel() {
    return numtel;
    }
    
    public void setNumtel(String numtel) {
    this.numtel = numtel;
    }
    
    public FichePatientDTO getFichePatient() {
    return fichePatient;
    }
    
    public void setFichePatient(FichePatientDTO fichePatient) {
    this.fichePatient = fichePatient;
    } 
}
    

