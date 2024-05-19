package com.melimed.cabinet.controllers;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;


import com.melimed.cabinet.models.RDV;
import com.melimed.cabinet.models.Patient;
import com.melimed.cabinet.services.RdvService;

import jakarta.validation.Valid;

import com.melimed.cabinet.services.PatientService;
import com.melimed.cabinet.dtos.RDVDTO;

@Controller
@RequestMapping("rdv")
public class RDVController {
    @Autowired
    private RdvService rdvService;
    @Autowired
    private PatientService patientService;


    // tableau de touts les rdv
    @GetMapping("/showall")
    public String showRDVList(Model model) {
        List<RDV> rdv = rdvService.getAllRdvs();
        model.addAttribute("rdv", rdv);
        return "packdoctor/rdv/showAll";
    }
    @GetMapping("/delete{id}")
    public String deleteCertificat(
            @PathVariable(name = "id") Long id) {

       rdvService.deleteRdv(id);

        return "redirect:/consultation/showall";
    }

    //pour secretaire
     @GetMapping("/showalls")
    public String showRDVLists(Model model) {
        List<RDV> rdv = rdvService.getAllRdvs();
        model.addAttribute("rdv", rdv);
        return "packsecretaire/rdv/showAll";
    }
 // tableau de touts les rdv d'un seul patient
 @GetMapping("/showall{id}")
 public String showRDvListByPatient(Model model, @PathVariable(name = "id") Long id) {
     
     Patient patient =patientService.getPatientById(id);
     List<RDV> rdv = rdvService.getAllRdvByPatient(patient);
     model.addAttribute("rdv", rdv);
     return "packdoctor/rdv/showAll";
 }
 //pour patient
  // tableau de touts les rdv d'un seul patient
 @GetMapping("/showallp{id}")
 public String showRDvListByPatientp(Model model, @PathVariable(name = "id") Long id) {
     
     Patient patient =patientService.getPatientById(id);
     List<RDV> rdv = rdvService.getAllRdvByPatient(patient);
     model.addAttribute("rdv", rdv);
     return "packpatient/rdv/showAll";
 }


//only for secretaire
  /*   @GetMapping("/create{id}")
    public String showCreatePage(Model model, @PathVariable(name = "id") Long id) {
      RDVDTO rdv= new RDVDTO();
      Patient patient =patientService.getPatientById(id);
      Calendar currentDate = Calendar.getInstance();

      List<String> oktime = rdvService.getAvailableTimes(currentDate);
      
    
    model.addAttribute("oktime", oktime);
    model.addAttribute("patient", patient);
    model.addAttribute("rdv", rdv);
    
    
      return ("packsecretaire/rdv/create");
    }
*/
     @PostMapping("/create{id}")
public String createRDV(
        @Valid @ModelAttribute("rdvDTO") RDVDTO rdvDTO,
        @PathVariable(name = "id") Long idpatient,
        BindingResult result, Model model) {
   try {rdvService.createRdv(rdvDTO); 
        return "packsecretaire/rdv/showAll";
   } catch (Exception e) { model.addAttribute("error", e.getMessage()); // Add the error message to the model
   List<RDV> rdv = rdvService.getAllRdvs(); // Get all RDVs to display
   model.addAttribute("rdv", rdv);
   return "packsecretaire/rdv/showAll";
  
   } 
}

}
