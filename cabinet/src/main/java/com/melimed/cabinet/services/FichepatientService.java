package com.melimed.cabinet.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.melimed.cabinet.dtos.FichePatientDTO;
import com.melimed.cabinet.repositories.AntecedantRepository;
import com.melimed.cabinet.repositories.FichePatientRepository;
import com.melimed.cabinet.repositories.PatientRepository;
import com.melimed.cabinet.models.*;

import java.util.List;


public class FichepatientService {


    private FichePatientRepository repo;
    private PatientRepository patientrepo;
    private AntecedantRepository antecedantrepo;

    @Autowired
    public void setRepo(AntecedantRepository antecedantrepo, FichePatientRepository repo, PatientRepository patientrepo) {
        this.repo = repo;
        this.patientrepo = patientrepo;
        this.antecedantrepo = antecedantrepo;
    }

    public List<FichePatient> getAllFiches() {
        return repo.findAll();
    }

    public FichePatient createFichePatient(FichePatientDTO fichePatientDTO) {
        FichePatient fichePatient=new FichePatient();
        Patient patient = new Patient();
        patient = patientrepo.findById(fichePatientDTO.getPatient().getIdPatient()).orElse(null);
        fichePatient.setPatient(patient);
        fichePatient.setAntecedant(antecedantrepo.findByPatient(patient));
     
        return repo.save(fichePatient);

    }
  

    public void deleteFichepatient(Long id) {
     repo.deleteById(id);
      }

}
