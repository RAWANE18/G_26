package com.melimed.cabinet.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.melimed.cabinet.models.RDV;
import com.melimed.cabinet.models.Patient;
import com.melimed.cabinet.services.RdvService;
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
        return "rdv/showAll";
    }
 // tableau de touts les rdv d'un seul patient
 @GetMapping("/showall{id}")
 public String showRDvListByPatient(Model model, @PathVariable(name = "id") Long id) {
     
     Patient patient =patientService.getPatientById(id);
     List<RDV> rdv = rdvService.getAllRdvByPatient(patient);
     model.addAttribute("rdv", rdv);
     return "rdv/showAll";
 }


    @GetMapping("/create{id}")
    public String showCreatePage(Model model, @PathVariable(name = "id") Long id) {
      RDVDTO rdvdto= new RDVDTO();
      Patient patient =patientService.getPatientById(id);
      model.addAttribute("patient", patient);
      model.addAttribute("rdvdto", rdvdto);
      return ("rdv/create");
    }

     @PostMapping("/create/{id}")
public String createRDV(
        @Valid @ModelAttribute("rdvDTO") RDVDTO rdvDTO,
        @PathVariable(name = "id") Long idpatient,
        BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "rdv/create";
    }
    rdvDTO.setPatientId(idpatient);

    try {
        rdvService.createRDV(rdvDTO);
        return "redirect:/patient/showall"; // Redirect to patient list if  is success
    } catch (Exception e) {
        model.addAttribute("error", e.getMessage()); // Add the error message to the model
        List<RDV> rdv = rdvService.getAllRdvs(); // Get all RDVs to display
        model.addAttribute("rdv", rdv);
        return "rdv/showAll"; // Show list of RDV the error message
    }
}

}
