package com.melimed.cabinet.services;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
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
  public boolean isOneHourAway(Calendar appointmentDate) {
    Calendar currentTime = Calendar.getInstance();
    currentTime.add(Calendar.HOUR_OF_DAY, 1); // Add one hour to the current time pour checker
    
    return appointmentDate.after(currentTime);
}
 //voir si il est deja pris  , retourne vrai si la liste est vrai  donc pas trouve dans la bdd
  public boolean isRDVFree(Calendar date) {
    List<RDV> appointments = repo.findAllByDate(date);
    return appointments.isEmpty();
}
//time needs to be only the allowed times
public List<Calendar> getAllowedAppointmentTimes() {
  List<Calendar> allowedTimes = new ArrayList<>();
  
  String[] allowedHours = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30",
                           "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30"};
  
  for (String hourString : allowedHours) {
      String[] parts = hourString.split(":");
      int hour = Integer.parseInt(parts[0]);
      int minute = Integer.parseInt(parts[1]);
      
      Calendar appointmentTime = Calendar.getInstance();
      appointmentTime.set(Calendar.HOUR_OF_DAY, hour);
      appointmentTime.set(Calendar.MINUTE, minute);
      appointmentTime.set(Calendar.SECOND, 0);
      appointmentTime.set(Calendar.MILLISECOND, 0);
      
      allowedTimes.add(appointmentTime);
  }
  
  return allowedTimes;
}





//creation du Rendez-vous
public RDV createRDV (RDVDTO appointmentDTO)throws Exception {
   RDV appointment=new RDV();
   appointment.setDate(appointmentDTO.getDate());
   appointment.setDatePriseRdv(appointmentDTO.getDatePriseRdv());
   appointment.setDescription(appointmentDTO.getDescription());
   appointment.setPatient(patientrepo.findByIdPatient(appointmentDTO.getPatientId()));
  //si il n'est pas pris et valide , save it 
   String err= "La date choisi est: ";  
   String check=err;
  if (!isAppointmentValid(appointment.getDate())){
      err=err+" en dehors des horraires de travail";
   }
   if(! isRDVFree(appointment.getDate())){
      err=err+" deja prise ";
   }
  if(! isOneHourAway(appointment.getDate())){
      err=err+" doit être au moins une heure postérieure à l'heure actuelle pour continuer.";
  } 
    if (err.equals(check)){ 
   return repo.save(appointment);
    }
    throw new Exception(err);

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
