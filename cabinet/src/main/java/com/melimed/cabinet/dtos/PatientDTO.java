package com.melimed.cabinet.dtos;

import java.util.Date;

public class PatientDTO {
    private Long idPatient;
    private String email;
    private String gender;
    private String adress;
    private Date birthdate;
    private String lastname;
    private String firstname;
    private String numtel;
    //foreigns
    private Long idFichePatient;
   // private Long idAntecedant;
    // Constructors
    public PatientDTO() {
    }

    public PatientDTO(Long idPatient, String email, String gender, String adress, Date birthdate, String lastname, String firstname, String numtel) {
        this.idPatient = idPatient;
        this.email = email;
        this.gender = gender;
        this.adress = adress;
        this.birthdate = birthdate;
        this.lastname = lastname;
        this.firstname = firstname;
        this.numtel = numtel;
    }

    // Getters and Setters
    public Long getIdPatient() {
        return idPatient;
    }
/*     public Long getIdAntecedant() {
        return idAntecedant;
    }*/
    public Long getIdFichePatient() {
        return idFichePatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 //   public void setIdAntecedant(Long idAntecedant) {
  //      this.idAntecedant = idAntecedant;
  //  }
    public void setIdFichePatient(Long idFichePatient) {
        this.idFichePatient = idFichePatient;
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
}
