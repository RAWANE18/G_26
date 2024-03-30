package pack1;

public class RendezVous {
    private int id;
    private String nomPatient;
    private String prenomPatient;
    private String date;
    private String heure;

   //getters
    public String getDate() {
     return date;
 }
 public String getHeure() {
    return heure;
 }
 public int getId() {
     return id;
 }
 public String getNomPatient() {
     return nomPatient;
 }
 public String getPrenomPatient() {
     return prenomPatient;
 }
 //setters
 public void setDate(String date) {
     this.date = date;
 }
 public void setHeure(String heure) {
     this.heure = heure;
 }
 public void setId(int id) {
     this.id = id;
 }
 public void setNomPatient(String nomPatient) {
     this.nomPatient = nomPatient;
 }
 public void setPrenomPatient(String prenomPatient) {
     this.prenomPatient = prenomPatient;
 }
 
}

