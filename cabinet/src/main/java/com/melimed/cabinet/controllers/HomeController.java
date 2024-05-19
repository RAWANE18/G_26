package com.melimed.cabinet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("home")
public class HomeController {
  @GetMapping("/now")
  public String showhomepage() {
      return "connection/home";
  }

   @GetMapping("/doctor")
  public String showdoctorpage() {
      return "connection/doctor";
  }
  @GetMapping("/register")
  public String showrpage() {
      return "connection/register";
  }
  @GetMapping("/secretaire")
  public String showsecpage() {
      return "connection/secretaire";
      
  }

  @GetMapping("/patient")
  public String showpatpage() {
      return "connection/Patient";
      
  }
}
