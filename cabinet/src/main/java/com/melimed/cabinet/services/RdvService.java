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
  
/* 
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

    private static final String[] AVAILABLE_HOURS = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30"};

    public List<Calendar> getAvailableDates() {
        List<Calendar> availableDates = new ArrayList<>();
        Calendar currentDate = Calendar.getInstance();
        currentDate.add(Calendar.HOUR, 1); // Set the minimum date to be at least 1 hour from now

        while (availableDates.size() < 7) { // Fetch available dates for the next 7 days
            if (isDateAvailable(currentDate)) {
                availableDates.add((Calendar) currentDate.clone());
            }
            currentDate.add(Calendar.DAY_OF_YEAR, 1);
        }

        return availableDates;
    }

    public boolean  timeisinList(Calendar date)
{// Check if the time is in the available hours list
        int hour = date.get(Calendar.HOUR_OF_DAY);
        int minute = date.get(Calendar.MINUTE);
        String dateTimeString = String.format("%02d:%02d", hour, minute);
        boolean isAvailableHour = false;
        for (String availableHour : AVAILABLE_HOURS) {
            if (availableHour.equals(dateTimeString)) {
                isAvailableHour = true;
                break;
            }
        }
        if (!isAvailableHour) {
            return false;
        }

// Add method to convert date and time to Calendar object
public Calendar convertToCalendar(String date, String time) {
  Calendar appointmentDateTime = Calendar.getInstance();
  String[] dateParts = date.split("-");
  int year = Integer.parseInt(dateParts[0]);
  int month = Integer.parseInt(dateParts[1]) - 1; // Month is 0-based in Calendar
  int day = Integer.parseInt(dateParts[2]);
  String[] timeParts = time.split(":");
  int hour = Integer.parseInt(timeParts[0]);
  int minute = Integer.parseInt(timeParts[1]);
  
  appointmentDateTime.set(year, month, day, hour, minute, 0);
  appointmentDateTime.set(Calendar.SECOND, 0);
  appointmentDateTime.set(Calendar.MILLISECOND, 0);
  
  return appointmentDateTime;
}

// Update createRDV method to use date and time from RDVDTO
public RDV createRDV(RDVDTO appointmentDTO) throws Exception {
  RDV appointment = new RDV();
 // Calendar appointmentDateTime = convertToCalendar(appointmentDTO.getDate(), appointmentDTO.getTime());
 // appointment.setDate(appointmentDateTime);
  appointment.setDatePriseRdv(appointmentDTO.getDatePriseRdv());
  appointment.setDescription(appointmentDTO.getDescription());
  appointment.setPatient(patientrepo.findByIdPatient(appointmentDTO.getPatientId()));

  String err= "La date choisi est: ";  
   String check=err;
  // Check appointment validity and availability
  if (!isAppointmentValid(appointment.getDate())) {
      err=err+" Appointment date is outside working hours.";
  }
  if (!isRDVFree(appointment.getDate())) {
      err=err+" Appointment date is already taken.";
  }
  if (!isOneHourAway(appointment.getDate())) {
      err=err+" Appointment must be at least one hour after the current time.";
  }
  if (err.equals(check)){ 
    return repo.save(appointment);
     }
     throw new Exception(err);
 
}





//creation du Rendez-vous
/*public RDV createRDV (RDVDTO appointmentDTO)throws Exception {
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

}*/
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
