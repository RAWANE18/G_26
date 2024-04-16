package cabinet_medical;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public  class Personne {
        @Id
        String nom;
        String prenom;
        String numTel; 
    
        public Personne(){}
        public Personne(String nom, String prenom, String numTel) {
            this.nom = nom;
            this.prenom = prenom;
            this.numTel = numTel;
        }
    //getters and setters
       public String getNom() {
           return nom;
       }
       public String getNumTel() {
           return numTel;
       }
       public String getPrenom() {
           return prenom;
       }
       public void setNom(String nom) {
           this.nom = nom;
       }
       public void setNumTel(String numTel) {
           this.numTel = numTel;
       }
       public void setPrenom(String prenom) {
           this.prenom = prenom;
       }

    }