package com.melimed.cabinet.services;


import org.springframework.beans.factory.annotation.Autowired;
import com.melimed.cabinet.repositories.OrdonnanceRepository;
import com.melimed.cabinet.repositories.PatientRepository;
import com.melimed.cabinet.models.Ordonnance;
import com.melimed.cabinet.dtos.OrdonnanceDTO;
import com.melimed.cabinet.models.Patient;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrdonnanceService {
  
    private OrdonnanceRepository repo;
    private PatientRepository patientrepo;
    @Autowired
    public void setRepo(OrdonnanceRepository repo, PatientRepository patientrepo) {
        this.repo = repo;
        this.patientrepo=patientrepo;
    }
    //show all ordonnances
  public List<Ordonnance> getAllOrdonnances() {
    return repo.findAll();
}
 
//create une ordonnance
public Ordonnance createOrdonnance(OrdonnanceDTO ordonnanceDto) {
    Ordonnance ordonnance = new Ordonnance();
    ordonnance.setContenu(ordonnanceDto.getContenu());
    
    // Using the PatientService to fetch the patient
    Patient patient = new Patient(); 
    patient = patientrepo.findById(ordonnanceDto.getPatientId()).orElse(null);
    ordonnance.setPatient(patient);
    
    return repo.save(ordonnance);
}
public OrdonnanceDTO createOrdonnanceDTO() {
    OrdonnanceDTO ordonnanceDTO = new OrdonnanceDTO();
    return ordonnanceDTO;
}

// Fetch all patient IDs
public List<Long> getAllPatientIds() {
    return patientrepo.findAll().stream()
        .map(Patient::getIdPatient)
        .collect(Collectors.toList());
}

}
