package com.melimed.cabinet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import com.melimed.cabinet.models.Antecedant;
import com.melimed.cabinet.models.Patient;
import com.melimed.cabinet.services.AntecedantService;
import com.melimed.cabinet.services.PatientService;
import com.melimed.cabinet.dtos.AntecedantDTO;

@Controller
@RequestMapping("antecedant")
public class AntecedantController {

    @Autowired
    private AntecedantService antecedantService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/showall")
    public String showAntecedantList(Model model) {
        List<Antecedant> antecedants = antecedantService.getAllAntecedants();
        model.addAttribute("antecedants", antecedants);
        return "antecedant/showAll";
    }

    @GetMapping("/create{id}")
    public String showCreatePage(Model model,@PathVariable(name = "id") Long id) {
        AntecedantDTO antecedantDTO = new AntecedantDTO();
        Patient patient = patientService.getPatientById(id);
        
        model.addAttribute("antecedantDTO", antecedantDTO);
        model.addAttribute("patient", patient);
        return "antecedant/create";
    }

    @PostMapping("/create")
    public String createAntecedant(@Valid @ModelAttribute("antecedantDTO") AntecedantDTO antecedantDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "antecedant/create";
        }
        antecedantService.createAntecedant(antecedantDTO);
        return "redirect:/patient/showall";
    }

    @GetMapping("/delete/{id}")
    public String deleteAntecedant(@PathVariable(name = "id") Long id) {
        antecedantService.deleteAntecedant(id);
        return "redirect:/antecedant/showall";
    }
}

