package com.melimed.cabinet.services;


import org.springframework.beans.factory.annotation.Autowired;


import com.melimed.cabinet.repositories.PatientRepository;
import com.melimed.cabinet.models.Patient;
import com.melimed.cabinet.dtos.PatientDTO;

import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class PatientService {
  
  private PatientRepository repo;
  
  @Autowired
  public void setRepo(PatientRepository repo) {
      this.repo = repo;
  }

  //show all patients
  public List<Patient> getAllPatients() {
    return repo.findAll();
}
//create a patient
public Patient createPatient(PatientDTO patientDto) {
    Patient patient = new Patient();
    patient.setLastname(patientDto.getLastname());
    patient.setFirstname(patientDto.getFirstname());
    patient.setNumtel(patientDto.getNumtel());
    patient.setEmail(patientDto.getEmail());
    patient.setAdress(patientDto.getAdress());
    patient.setGender(patientDto.getGender());
    patient.setBirthdate(patientDto.getBirthdate());
    return repo.save(patient);
}

public PatientDTO createPatientDTO() {
    PatientDTO patientDTO = new PatientDTO();
    return patientDTO;
}

 //supprimer un patient
 public void deletePatient(Long id) {
    repo.deleteById(id);
}
//recupere un patient by son id
public Patient getPatientById(Long patientId) {
    return repo.findById(patientId).orElse(null);
}

}
