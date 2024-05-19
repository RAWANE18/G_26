package com.melimed.cabinet.models;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table (name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    private String email;
  
    private String gender;
    
    private String adress;
  
    private Date  Birthdate;
   
    private String lastname;
    
    private String  firstname;
    
    private String  numtel;



    //getters and setters

    public String getAdress() {
        return adress;
    }
    public Date getBirthdate() {
        return Birthdate;
    }
    public String getEmail() {
        return email;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getGender() {
        return gender;
    }
    public Long getIdPatient() {
        return idPatient;
    }
    public String getLastname() {
        return lastname;
    }
    public String getNumtel() {
        return numtel;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public void setBirthdate(Date birthdate) {
        Birthdate = birthdate;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }



}
