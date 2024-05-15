package com.melimed.cabinet.services;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.melimed.cabinet.repositories.PatientRepository;
import com.melimed.cabinet.repositories.RdvRepository;
import com.melimed.cabinet.models.Patient;
import com.melimed.cabinet.models.RDV;
import com.melimed.cabinet.dtos.RDVDTO;


import org.springframework.stereotype.Service;

@Service
public class RdvService {
    private RdvRepository repo;
    private PatientRepository patientrepo;
    @Autowired
    public void setRepo(RdvRepository repo, PatientRepository patientrepo) {
        this.repo = repo;
        this.patientrepo=patientrepo;
    }
  
    //show all RDV
    public List<RDV> getAllRdvs() {
      return repo.findAll();
  }
  //show all RDV of one patient
public List<RDV> getAllRdvByPatient(Patient patient){
     return repo.findAllByPatient(patient); 
}




//delete an RDV
  public void deleteRdv(Long id) {
    repo.deleteById(id);
}

}
