package com.melimed.cabinet.services;
import org.springframework.beans.factory.annotation.Autowired;
import com.melimed.cabinet.repositories.AntecedantRepository;
import com.melimed.cabinet.repositories.PatientRepository;
import com.melimed.cabinet.dtos.AntecedantDTO;
import com.melimed.cabinet.models.Antecedant;
import com.melimed.cabinet.models.Patient;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AntecedantService {
    private AntecedantRepository repo;
    private PatientRepository patientrepo;
    @Autowired
    public void setRepo(AntecedantRepository repo, PatientRepository patientrepo) {
        this.repo = repo;
        this.patientrepo=patientrepo;
    }
  

//creer un certificat
public Antecedant createAntecedant(AntecedantDTO antecedantDTO) {
    Antecedant antecedant = new Antecedant();
    antecedant.setAntecedantMedicaux(antecedantDTO.getAntecedantMedicaux());
    antecedant.setAntecedantChirurgicaux(antecedantDTO.getAntecedantChirurgicaux());
    // Using the PatientService to fetch the patient
    Patient patient = new Patient(); 
    patient = patientrepo.findById(antecedantDTO.getPatientId()).orElse(null);
    antecedant.setPatient(patient);
    
    return repo.save(antecedant);
}
  //show all certificats
  public List<Antecedant> getAllAntecedants() {
    return repo.findAll();
}

 


public AntecedantDTO createAntecedantDTO() {
    AntecedantDTO antecedantDTO= new AntecedantDTO();
    return antecedantDTO;
}

// Fetch all patient IDs
public List<Long> getAllPatientIds() {
    return patientrepo.findAll().stream()
        .map(Patient::getIdPatient)
        .collect(Collectors.toList());
}
 //supprimer un antecedant
 public void deleteAntecedant(Long id) {
    repo.deleteById(id);
}




}
