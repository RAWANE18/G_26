package com.melimed.cabinet.services;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
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
  

     // Check if the appointment date is from Saturday to Thursday, between 8am and 6pm
    public boolean isAppointmentValid(Calendar date) {
     
      int day = date.get(Calendar.DAY_OF_WEEK);
      int h = date.get(Calendar.HOUR_OF_DAY);
      return (day >= Calendar.SATURDAY && day <= Calendar.THURSDAY) && (h >= 8 && h < 18);
  }
 //voir si il est deja pris  , retourne vrai si la liste est vrai  donc pas trouve dans la bdd
  public boolean isRDVFree(Calendar date) {
    List<RDV> appointments = repo.findAllByDate(date);
    return appointments.isEmpty();
}
//creation du Rendez-vous
public RDV createRDV (RDVDTO appointmentDTO)throws Exception {
   RDV appointment=new RDV();
   appointment.setDate(appointmentDTO.getDate());
   appointment.setDatePriseRdv(appointmentDTO.getDatePriseRdv());
   appointment.setDescription(appointmentDTO.getDescription());
   appointment.setPatient(patientrepo.findByIdPatient(appointmentDTO.getPatientId()));
  //si il n'est pas pris et valide , save it 
  if (isAppointmentValid(appointment.getDate()) && isRDVFree(appointment.getDate())) {
     
   return repo.save(appointment);
  }
   throw new Exception("Invalid appointment date or already booked.");

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
