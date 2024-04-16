package cabinet_medical.entity;

import org.springframework.data.annotation.Id;

import cabinet_medical.Personne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
@Entity
@Table(name="secretaire")
public class Secretaire extends Personne{
        @Id 
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private long Idsecretaire;
        @Column (name="nom")
        private String nom;
        @Column (name="prenom")
        private String prenom;
        @Column (name="numtel")
        private String numtel;
    //constructeur vide
    public Secretaire(){/*constructeur vide*/}
    
    //constructeur complet
    public Secretaire(String nom,String prenom, String numtel){
        this.nom=nom;
         this.prenom=prenom;
         this.numtel=numtel;

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
    
    public long getIdsecretaire() {
        return Idsecretaire;
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
  
    
    
}
