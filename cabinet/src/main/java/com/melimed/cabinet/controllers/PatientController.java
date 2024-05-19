package com.melimed.cabinet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.melimed.cabinet.models.Patient;
import com.melimed.cabinet.services.PatientService;
import com.melimed.cabinet.dtos.PatientDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // tableau de tout les patients

    @GetMapping("/showall")
    public String showPatientList(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "packdoctor/patient/showAll";
    }
    @GetMapping("/showalls")
    public String showPatientLists(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "packsecretaire/patient/showAll";
    }

    @GetMapping("/showallp")
    public String showPatientListp(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "packpatient/patient/show";
    }
//show one patient
   @GetMapping("/showone{id}")
   public String showPatient(Model model, @PathVariable(name = "id") Long id) {
    Patient patients = patientService.getPatientById(id);
    model.addAttribute("patients", patients);
    return "packdoctor/patient/showAll";
}
//show one patient
@GetMapping("/showonep{id}")
public String showPatientp(Model model, @PathVariable(name = "id") Long id) {
 Patient patients = patientService.getPatientById(id);
 model.addAttribute("patients", patients);
 return "packpatient/patient/showAll";
}
@GetMapping("chose")
public String showChose(Model model,@CookieValue(name = "id", defaultValue = "") 
String cookie) {
    List<Patient> patients = patientService.getAllPatients();
    model.addAttribute("patients", patients);
    return "packpatient/patient/showchose";
}

//meme pour secretaire
@GetMapping("/showones{id}")
   public String showPatients(Model model, @PathVariable(name = "id") Long id) {
    Patient patients = patientService.getPatientById(id);
    model.addAttribute("patients", patients);
    return "packsecretaire/patient/showAll";
}
    // show the html page to create the patient
    @GetMapping("/create")
    public String showCreatePage(Model model) {

        model.addAttribute("patientDTO", new PatientDTO());
        return "packdoctor/patient/create";
    }
    @GetMapping("/creates")
    public String showCreatePages(Model model) {

        model.addAttribute("patientDTO", new PatientDTO());
        return "packsecretaire/patient/creates";
    }


    // save the data of the created patient in the database
    @PostMapping("/create")
    public String createPatient(@Valid @ModelAttribute PatientDTO patientDto, BindingResult result, HttpServletResponse response) throws UnsupportedEncodingException {
        if (result.hasErrors()) {
            return "packdoctor/patient/create";
        }
       Patient patient= patientService.createPatient(patientDto);
              
        String ident = patient.getIdPatient().toString();
        Cookie idCookie = new Cookie("id", URLEncoder.encode(ident, "UTF-8"));
        idCookie.setMaxAge(604800);

        response.addCookie(idCookie);
        return "redirect:/patient/showall";
    }
    @PostMapping("/creates")
    public String createPatients(@Valid @ModelAttribute PatientDTO patientDto, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            return "packsecretaire/patient/create";
        }
        patientService.createPatient(patientDto);
        return "redirect:/patient/showalls";
    }

    

    @GetMapping("/delete{id}")
    public String deletePatient(
            @PathVariable(name = "id") Long id) {

        patientService.deletePatient(id);

        return "redirect:/patient/showall";
    }

    @GetMapping("/deletes{id}")
    public String deletePatients(
            @PathVariable(name = "id") Long id) {

        patientService.deletePatient(id);

        return "redirect:/patient/showalls";
    }

}