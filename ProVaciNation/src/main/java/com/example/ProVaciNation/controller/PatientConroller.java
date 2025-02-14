package com.example.ProVaciNation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProVaciNation.DTO.Request.PatientRequest;
import com.example.ProVaciNation.DTO.Response.PatientResponse;
import com.example.ProVaciNation.Enum.Gender;
import com.example.ProVaciNation.service.PatientService;

@RestController
@RequestMapping("/patient")

public class PatientConroller {
    @Autowired 
    PatientService patientService;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody PatientRequest patientRequest){
        try{
            PatientResponse patientResponse = patientService.addPatient(patientRequest);              
            //return new ResponseEntity("patient saved successfully",HttpStatus.CREATED);
            return new ResponseEntity(patientResponse,HttpStatus.CREATED);
        }catch(Exception e){
            //return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
            return new ResponseEntity("Invalid request",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/get")
    public PatientResponse getPatient(@RequestParam("id") int id){
        return patientService.getPatient(id);
    }

    @GetMapping("/get/gender/{gender}") //gender specified in endpoint inside {} this refers to the pathVariable gender
    public List<PatientResponse> getSpecificGenderPatients(@PathVariable("gender") Gender gender){
        return patientService.getSpecificGenderPatients(gender);
    }
}
