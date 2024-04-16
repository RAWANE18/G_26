package cabinet_medical.entity;



import cabinet_medical.Personne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="medecins")
public class Medecin extends Personne{
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Idmedecin;
    private String specialite;
//constructeur vide
public Medecin(){/*constructeur vide*/}

//constructeur complet
public Medecin(String specialite,String nom,String prenom, String numtel){
    super(nom,prenom,numtel);
    this.specialite=specialite;
}

 
//getters
@Override
public String getNom() {

    return super.getNom();
}
@Override
public String getPrenom() {
    return super.getPrenom();
}
@Override
public String getNumTel() {
    return super.getNumTel();
}
public String getSpecialite() {
    return specialite;
}
public long getIdmedecin() {
    return Idmedecin;
}


  //setters
@Override
public void setNom(String nom) {
    super.setNom(nom);
}
@Override
public void setNumTel(String numTel) {
    super.setNumTel(numTel);
}
@Override
public void setPrenom(String prenom) {
    super.setPrenom(prenom);
}
public void setIdmedecin(long idmedecin) {
    Idmedecin = idmedecin;
}
public void setSpecialite(String specialite) {
    this.specialite = specialite;
}
}
