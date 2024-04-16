package cabinet_medical.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "patients")
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    @Column(name="email")
    private String email;
    @Column(name="gender")
    private String gender;
    @Column(name="adress")
    private String adress;
    @Column(name="Birthdate")
    private Date  Birthdate;
    @Column(name="lastname")
    private String lastname;
    @Column(name="firstname")
    private String  firstname;
    @Column(name="numtel")
    private String  numtel;

    @OneToMany(mappedBy = "patient")
    private List<Ordonnance> ordonnances;

    
     public Patient(){}

    public Patient(String firstname, String lastname, String phonenumber,String email,String gender,String adress,Date birthdate)
    {
    this.lastname=lastname;
    this.firstname=firstname;
    this.numtel=phonenumber;
    this.email=email;
    this.gender=gender;
    this.adress=adress;
    this.Birthdate=birthdate;
    }

//getteur setteur
    public String getFirstname() {
    return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getNumtel() {
        return numtel;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }
    public Long getIdPatient()
    {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) 
    {
        this.idPatient = idPatient;
    }
    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getAdress() 
    {
        return adress;
    }

    public void setAdress(String adress) 
    {
        this.adress = adress;
    }

    public Date getBirthdate() 
    {
        return Birthdate;
    }

    public void setBirthdate(Date birthdate) 
    {
        Birthdate = birthdate;
    }


}