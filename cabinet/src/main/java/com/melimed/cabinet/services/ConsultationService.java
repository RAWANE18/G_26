package com.melimed.cabinet.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.melimed.cabinet.repositories.ConsultationRepository;
import com.melimed.cabinet.repositories.PatientRepository;
import com.melimed.cabinet.models.Consultation;
import com.melimed.cabinet.dtos.ConsultationDTO;
import com.melimed.cabinet.models.Patient;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ConsultationService {
  private ConsultationRepository repo;
  private PatientRepository patientrepo;

  @Autowired
  public void setRepo(ConsultationRepository repo, PatientRepository patientrepo) {
    this.repo = repo;
    this.patientrepo = patientrepo;

  }

  // show all consultations
  public List<Consultation> getAllConsultations() {
    return repo.findAll();
  }

  public Consultation getOneConsultation(Long consultationid) {
    return repo.findById(consultationid).orElse(null);
  }

  public List<Consultation> getAllConsultationPatient(long idpatient) {
    Patient patient = patientrepo.findById(idpatient).orElse(null);
    return repo.findAllByPatient(patient);
  }

  // create une consultation a vide
  public Consultation createConsultation(ConsultationDTO consultationDTO) {

    // Créer la consultation
    Consultation consultation = new Consultation();
    consultation.setDateConsultation(consultationDTO.getDateConsultation());
    // Using the PatientService to fetch the patient
    Patient patient = new Patient();
    patient = patientrepo.findById(consultationDTO.getIdPatient()).orElse(null);
    consultation.setPatient(patient);

    return repo.save(consultation);

  }

  // Fetch all patient IDs
  public List<Long> getAllPatientIds() {
    return patientrepo.findAll().stream()
        .map(Patient::getIdPatient)
        .collect(Collectors.toList());
  }

  // find by id
  public Consultation getById(Long id) {
    return repo.findByIdConsultation(id);
  }

  // suppression
  public void deleteConsultation(Long id) {
    repo.deleteById(id);
  }

}
