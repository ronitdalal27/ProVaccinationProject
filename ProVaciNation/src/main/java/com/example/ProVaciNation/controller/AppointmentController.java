package com.example.ProVaciNation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProVaciNation.DTO.Response.AppointmentResponse;
import com.example.ProVaciNation.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestParam("pid") int patientID,@RequestParam("did")int doctorID){
        try{
            AppointmentResponse appointmentResponse =  appointmentService.bookAppointment(patientID,doctorID);
            return new ResponseEntity(appointmentResponse,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }

    }
    
}
