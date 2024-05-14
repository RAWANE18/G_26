package com.melimed.cabinet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;

import com.melimed.cabinet.models.Consultation;
import com.melimed.cabinet.models.Ordonnance;
import com.melimed.cabinet.services.ConsultationService;
import com.melimed.cabinet.services.OrdonnanceService;
import com.melimed.cabinet.dtos.OrdonnanceDTO;

@Controller
@RequestMapping("ordonnance")
public class OrdonnanceController {
   
    @Autowired
    private OrdonnanceService ordonnanceService;
    @Autowired
    private ConsultationService consultationService;
    //tableau de toutes les ordonnances
    @GetMapping("/showall")
    public String showOrdonnanceList(Model model) {
        List<Ordonnance> ordonnances = ordonnanceService.getAllOrdonnances();
        model.addAttribute("ordonnances", ordonnances);
        return "ordonnance/showAll";
    }

   //show the html page to create the ordonnance
   @GetMapping("/create{id}")
   public String showCreatePage(Model model,  @PathVariable(name = "id") Long id) {
    List<Long> patientIds = ordonnanceService.getAllPatientIds();   
    OrdonnanceDTO ordonnanceDTO = new OrdonnanceDTO();
    Consultation consultation =consultationService.getById(id); 
       model.addAttribute("ordonnanceDTO", ordonnanceDTO);
       model.addAttribute("patientIds", patientIds);
       model.addAttribute("consultation", consultation);
       return "ordonnance/create";
   }

    //save the data of the created ordonnance in the database
@PostMapping("/create{id}")

public String createOrdonnance(@Valid @ModelAttribute("ordonnanceDTO") OrdonnanceDTO ordonnanceDTO, BindingResult result,Model model) {
    if (result.hasErrors()) {
        return "ordonnance/create";
    }
    ordonnanceService.createOrdonnance(ordonnanceDTO);
    return "redirect:/patient/showall";
}
//suppression
@GetMapping("/delete{id}")
public String deleteOrdonnace(
        @PathVariable(name = "id") Long id) {

    ordonnanceService.deleteOrdonnace(id);

    return "redirect:/ordonnance/showall";
}


}
