package com.melimed.cabinet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melimed.cabinet.dtos.FichePatientDTO;
import com.melimed.cabinet.repositories.AntecedantRepository;
import com.melimed.cabinet.repositories.FichePatientRepository;
import com.melimed.cabinet.repositories.PatientRepository;
import com.melimed.cabinet.models.*;

import java.util.List;

@Service
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
    public FichePatient getFicheOne(Long id) {
        return repo.findByPatient(patientrepo.findByIdPatient(id));
    }
    public FichePatient createFichePatient(FichePatientDTO fichePatientDTO) {
        FichePatient fichePatient=new FichePatient();
        fichePatient.setDateCreation(fichePatientDTO.getDateCreation());
        fichePatient.setGroupesanguin(fichePatientDTO.getGroupesanguin());
        fichePatient.setEtatCivil(fichePatientDTO.getEtatCivil());
        fichePatient.setProfession(fichePatientDTO.getProfession());
        fichePatient.setSecuriteSociale(fichePatientDTO.getSecuriteSociale());
        
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
