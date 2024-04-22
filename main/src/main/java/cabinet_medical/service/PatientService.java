package cabinet_medical.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cabinet_medical.dto.PatientDTO;
import cabinet_medical.entity.Patient;
import cabinet_medical.repository.PatientRepository;
import cabinet_medical.exception.PatientNotFoundException;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    //show la liste des patients 

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    //creer un patient
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    public PatientDTO createPatientDTO() {
    PatientDTO patientDTO = new PatientDTO();
    return patientDTO;
}
public Patient createPatient(PatientDTO patientDto) {
    Patient patient = new Patient();
    patient.setLastname(patientDto.getLastname());
    patient.setFirstname(patientDto.getFirstname());
    patient.setNumtel(patientDto.getNumtel());
    patient.setEmail(patientDto.getEmail());
    patient.setAdress(patientDto.getAdress());
    patient.setGender(patientDto.getGender());
    patient.setBirthdate(patientDto.getBirthdate());
    return patientRepository.save(patient);
}

  
   //recuperer un patient de par son id
    public Patient getPatientById(Long id) {
            return patientRepository.findById(id)
                    .orElseThrow(() -> new PatientNotFoundException(id));
    }
     //recuperer un patient par son nom
    public Patient getPatientByName(String name) {
        return patientRepository.findByLastname(name);
    }
    //supprimer un patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
    //update un patient
    

    //update patient name
    public Patient updatePatientName(Long id, String patient){
        Patient patient1=this.getPatientById(id);
        patient1.setLastname(patient);
        return patient1;
    }
}
