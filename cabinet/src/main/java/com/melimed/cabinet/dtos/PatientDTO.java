package com.melimed.cabinet.dtos;

import java.util.Date;

public class PatientDTO {
    private Long idPatient;
    private String email;
    private String gender;
    private String address;
    private Date birthdate;
    private String lastname;
    private String firstname;
    private String numtel;

    // Constructors
    public PatientDTO() {
    }

    public PatientDTO(Long idPatient, String email, String gender, String address, Date birthdate, String lastname, String firstname, String numtel) {
        this.idPatient = idPatient;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.birthdate = birthdate;
        this.lastname = lastname;
        this.firstname = firstname;
        this.numtel = numtel;
    }

    // Getters and Setters
    public Long getIdPatient() {
        return idPatient;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
