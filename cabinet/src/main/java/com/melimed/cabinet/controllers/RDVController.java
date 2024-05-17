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
    public String showOrdonnanceList(Model model) {
        List<RDV> rdv = rdvService.getAllRdvs();
        model.addAttribute("rdv", rdv);
        return "rdv/showAll";
    }


     // save the data of the created ordonnance in the database
     @PostMapping("/create{id}")
     public String createRdv(
             @Valid @ModelAttribute("rdvDTO") RDVDTO rdvDTO,
             @PathVariable(name = "id") Long idpatient,
             BindingResult result, Model model) {
         if (result.hasErrors()) {
             return "rdvcreate";
         }
         rdvDTO.setPatientId(idpatient);
 
      //   rdvService.createRdv(rdvDTO);
         return "redirect:/patient/showall";
     }
}
