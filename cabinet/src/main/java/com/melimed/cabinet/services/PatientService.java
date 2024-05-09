package com.melimed.cabinet.services;


import org.springframework.beans.factory.annotation.Autowired;


import com.melimed.cabinet.repositories.PatientRepository;
import com.melimed.cabinet.models.Patient;
import com.melimed.cabinet.dtos.PatientDTO;

import java.util.List;



public class PatientService {
  @Autowired
  private PatientRepository repo;


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

 //supprimer un patient
 public void deletePatient(Long id) {
    repo.deleteById(id);
}

}
