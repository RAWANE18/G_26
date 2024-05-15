package com.melimed.cabinet.controllers;

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

    //donner toutes les fiches patient
    @GetMapping("/showall")
    public String showFichepatientList(Model model) {
        List<FichePatient> fiches = fichepatientService.getAllFiches();
        model.addAttribute("fiches", fiches);
        return "fichepatient/showAll";
    }
  
//create une fiche patient
    @GetMapping("/create{id}")
    public String showCreatePage(Model model, @PathVariable(name = "id") Long id) {
        FichePatientDTO fichePatientDTO = new FichePatientDTO();
    
        model.addAttribute("fichepatientDTO", fichePatientDTO);
        return "consultation/create";
    }

   // save the data of the created fichepatient in the database
   @PostMapping("/create{id}")
   public String createFichepatient(@Valid @ModelAttribute("fichePatientDTO") FichePatientDTO fichePatientDTO,
           BindingResult result, Model model,
           @PathVariable(name = "id") Long id) {

       if (result.hasErrors()) {
           return "consultation/create";
       }

       // consultationDTO.
       fichePatientDTO.setPatient(patientService.getPatientById(id));
       fichePatientDTO.setAntecedant(antecedantService.getByIdPatient(fichePatientDTO.getPatient().getIdPatient()));
       fichepatientService.createFichePatient(fichePatientDTO);

       return "redirect:/patient";
   }

  
    @GetMapping("/delete{id}")
    public String deleteFichepatient(
            @PathVariable(name = "id") Long id) {

        fichepatientService.deleteFichepatient(id);

        return "redirect:/consultation/showall";
    }
}
