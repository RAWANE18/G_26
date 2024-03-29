package pack1;
public abstract class Personne {
    String nom;
    String prenom;
    String numTel; 


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
