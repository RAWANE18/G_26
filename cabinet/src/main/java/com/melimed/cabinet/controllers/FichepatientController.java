package com.melimed.cabinet.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.melimed.cabinet.models.Antecedant;
import com.melimed.cabinet.models.FichePatient;
import com.melimed.cabinet.models.Patient;
import com.melimed.cabinet.services.AntecedantService;
import com.melimed.cabinet.services.FichepatientService;
import com.melimed.cabinet.services.PatientService;
import com.melimed.cabinet.dtos.FichePatientDTO;

@Controller
@RequestMapping("fiche")
public class FichepatientController {
    @Autowired
    private FichepatientService fichepatientService;
    @Autowired
    private AntecedantService antecedantService;
    @Autowired
    private PatientService patientService;
    private static final List<String> ALLOWED_GROUPE_SANGUIN = Arrays.asList("A+", "B+", "O+", "A-", "B-", "O-");
    
    //donner toutes les fiches patient
    @GetMapping("/showall")
    public String showFichepatientList(Model model) {
        List<FichePatient> fiches = fichepatientService.getAllFiches();
        model.addAttribute("fiches", fiches);
        return "fichePatient/showAll";
    }
  
//create une fiche patient
    @GetMapping("/create")
    public String showCreatePage(Model model) {
        FichePatientDTO fichePatientDTO = new FichePatientDTO();
       
        
        model.addAttribute("fichePatientDTO", fichePatientDTO);
        return "fichePatient/create";
    }

   // save the data of the created fichepatient in the database
   @PostMapping("/create")
   public String createFichepatient(@Valid @ModelAttribute("fichePatientDTO") FichePatientDTO fichePatientDTO,
           BindingResult result, Model model) {
            if (!ALLOWED_GROUPE_SANGUIN.contains(fichePatientDTO.getGroupesanguin())) {
                throw new IllegalArgumentException("groupe sanguin invalide");
            }
       if (result.hasErrors()) {
           return "fichePatient/create";
       }

       // fichepatient DTO.
        fichepatientService.createFichePatient(fichePatientDTO);

       return "redirect:/fiche/showall";
   }

  
    @GetMapping("/delete{id}")
    public String deleteFichepatient(
            @PathVariable(name = "id") Long id) {

        fichepatientService.deleteFichepatient(id);

        return "redirect:/fiche/showall";
    }
}
