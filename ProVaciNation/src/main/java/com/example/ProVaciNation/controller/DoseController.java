package com.example.ProVaciNation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProVaciNation.Enum.VaccineBrand;
import com.example.ProVaciNation.model.Dose;
import com.example.ProVaciNation.service.DoseService;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

    @PostMapping("/vaccinate")
    public Dose addDose(@RequestParam("id") int patientid,@RequestParam("brand") VaccineBrand vaccineBrand){ //two parameters,bcoz which patient is taking what dose
        return doseService.addDose(patientid,vaccineBrand);
    }
    
}
