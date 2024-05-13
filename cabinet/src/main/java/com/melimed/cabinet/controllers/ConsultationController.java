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
import com.melimed.cabinet.dtos.ConsultationDTO;


@Controller
@RequestMapping("consultation")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private OrdonnanceService ordonnanceService;
    //tableau de toutes les ordonnances
    @GetMapping("/showall")
    public String showConsultationList(Model model) {
        List<Consultation> consultations = consultationService.getAllConsultations();
        model.addAttribute("consultations", consultations);
        return "consultation/showAll";
    }

    //show une consultation
    @GetMapping("/show{id}")
    public String showConsultation (Model model ,  @PathVariable(name = "id") Long id) {
        Consultation consultations = consultationService.getOneConsultation(id);
        List<Ordonnance> ordonnances = ordonnanceService.getAllOrdonnances();
        model.addAttribute("ordonnances", ordonnances);
        model.addAttribute("consultations", consultations);
        return "consultation/show";
    } 
      //show the html page to create the ordonnance
   @GetMapping("/create")
   public String showCreatePage(Model model) {  
    ConsultationDTO consultationDTO = new ConsultationDTO();
       model.addAttribute("consultationDTO", consultationDTO);
       return "consultation/create";
   }

    //save the data of the created ordonnance in the database
@PostMapping("/create")

public String createConsultation(@Valid @ModelAttribute("consultationDTO") ConsultationDTO consultationDTO, BindingResult result,Model model) {
    if (result.hasErrors()) {
        return "Consultation/create";
    }
    consultationService.createConsultation(consultationDTO);
    return "redirect:/consultation";
}


    @GetMapping("/delete{id}")
    public String deleteCertificat(
            @PathVariable(name = "id") Long id) {

        consultationService.deleteConsultation(id);

        return "redirect:/consultation/showall";
    }
}
