package com.example.ProVaciNation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProVaciNation.model.Doctor;
import com.example.ProVaciNation.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    //get doctor by id
    @GetMapping("/get")
    public Doctor getDoctor(@RequestParam("id") int id){
        return doctorService.getDoctor(id);
    }

    @DeleteMapping("/delete")
    public String deleteDoctor(@RequestParam("id") int id){
        return doctorService.deleteDoctor(id);
    }
    
}
