package cabinet_medical.dto;



public class AntecedantDTO {

private Long id;
private String antecedantMedicaux;
private String antecedantChirurgicaux;
private Long patientId;
private Long fichePatientId;
private String contenu;

public AntecedantDTO() {
}

public AntecedantDTO(Long id,String contenu ,String antecedantMedicaux, String antecedantChirurgicaux, Long patientId, Long fichePatientId) {
this.id = id;
this.antecedantMedicaux = antecedantMedicaux;
this.antecedantChirurgicaux = antecedantChirurgicaux;
this.patientId = patientId;
this.fichePatientId = fichePatientId;
this.contenu = contenu;
}

// Getters and setters
public void setContenu(String contenu) {
    this.contenu = contenu;
}
public String getContenu(){
 return contenu ;
}

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getAntecedantMedicaux() {
return antecedantMedicaux;
}

public void setAntecedantMedicaux(String antecedantMedicaux) {
this.antecedantMedicaux = antecedantMedicaux;
}

public String getAntecedantChirurgicaux() {
return antecedantChirurgicaux;
}

public void setAntecedantChirurgicaux(String antecedantChirurgicaux) {
this.antecedantChirurgicaux = antecedantChirurgicaux;
}

public Long getPatientId() {
return patientId;
}

public void setPatientId(Long patientId) {
this.patientId = patientId;
}

public Long getFichePatientId() {
return fichePatientId;
}

public void setFichePatientId(Long fichePatientId) {
this.fichePatientId = fichePatientId;
}
}
