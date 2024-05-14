package com.melimed.cabinet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;

import com.melimed.cabinet.models.Certificat;
import com.melimed.cabinet.models.Consultation;
import com.melimed.cabinet.services.CertificatService;
import com.melimed.cabinet.services.ConsultationService;
import com.melimed.cabinet.dtos.CertificatDTO;


@Controller
@RequestMapping("certificat")
public class CertificatController {

    @Autowired
    private CertificatService certificatService;
    @Autowired
    private ConsultationService consultationService;
    //tableau de toutes les ordonnances
    @GetMapping("/showall")
    public String showOrdonnanceList(Model model) {
        List<Certificat> certificats = certificatService.getAllCertificats();
        model.addAttribute("certificats", certificats);
        return "certificat/showAll";
    }

   //show the html page to create the ordonnance
   @GetMapping("/create{id}")
   public String showCreatePage(Model model,  @PathVariable(name = "id") Long id) {
    List<Long> patientIds = consultationService.getAllPatientIds();   
   CertificatDTO certificatDTO = new CertificatDTO();
    Consultation consultation =consultationService.getById(id); 
       model.addAttribute("certificatDTO", certificatDTO);
       model.addAttribute("patientIds", patientIds);
       model.addAttribute("consultation", consultation);
       return "ordonnance/create";
   }

    //save the data of the created ordonnance in the database
@PostMapping("/create")

public String createCertificat(@Valid @ModelAttribute("certificatDTO") CertificatDTO certificatDTO, BindingResult result,Model model) {
    if (result.hasErrors()) {
        return "certificat/create";
    }
    certificatService.createCertificat(certificatDTO);
    return "redirect:/patient/showall";
}

@GetMapping("/delete{id}")
    public String deleteCertificat(
            @PathVariable(name = "id") Long id) {

        certificatService.deleteCertificat(id);

        return "redirect:/certificat/showall";
    }
}
