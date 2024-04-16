package cabinet_medical.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="")
public class SuiviMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsuivi ;
     @Column(name="lastname")
    private String lastname;
    @Column(name="firstname")
    private String  firstname;
    @Column(name="numtel")
    private String  numtel;
    //a rajouter apres le truc qui differentie de la fichepatient
    //le rajouter au constructeur

    @OneToOne
    @JoinColumn(name = "fiche_patient_id")
    private FichePatient fichePatients;



     public FichePatient getFichePatients() {
         return fichePatients;
     }
     public String getFirstname() {
         return firstname;
     }
     public Long getIdsuivi() {
         return idsuivi;
     }
     public String getLastname() {
         return lastname;
     }
     public String getNumtel() {
         return numtel;
     }
     public void setFichePatients(FichePatient fichePatients) {
         this.fichePatients = fichePatients;
     }
     public void setFirstname(String firstname) {
         this.firstname = firstname;
     }
     public void setIdsuivi(Long idsuivi) {
         this.idsuivi = idsuivi;
     }
     public void setLastname(String lastname) {
         this.lastname = lastname;
     }
     public void setNumtel(String numtel) {
         this.numtel = numtel;
     }
   //Constructeur vide
    public SuiviMedical(){/*vide*/}
   //constructeur
   public SuiviMedical(String lastname, String firstname,String numtel){
    this.firstname=firstname;
    this.lastname=lastname;
    this.numtel=numtel;
      }
      //rajouter une fiche patient au suivi medical et le linker dans l'autre sens
      public void addfichepatient(FichePatient fichePatient) {
        this.fichePatients = fichePatient;
        fichePatients.setSuivimedical(this);
    }
   
}
