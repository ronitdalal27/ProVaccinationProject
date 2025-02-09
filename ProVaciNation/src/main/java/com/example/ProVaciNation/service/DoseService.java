package com.example.ProVaciNation.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProVaciNation.Enum.VaccineBrand;
import com.example.ProVaciNation.exception.PatientNotFoundException;
import com.example.ProVaciNation.model.Dose;
import com.example.ProVaciNation.model.Patient;
import com.example.ProVaciNation.repository.DoseRepository;
import com.example.ProVaciNation.repository.PatientRepository;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PatientRepository patientRepository; // autowierd bcoz we want patient object in addDose

    public Dose addDose(int patientid, VaccineBrand vaccineBrand) {
        //to add dose first check whether the patient id is valid or not
        Optional<Patient> optionalPatient = patientRepository.findById(patientid);
        
        if(optionalPatient.isEmpty()){
            throw new PatientNotFoundException("invalid patient id");
        }

        Patient patient = optionalPatient.get();

        if(patient.isVaccinated()){
            throw new RuntimeException("patient already vaccinated");
        }

        Dose dose = new Dose();

        patient.setVaccinated(true);        
        dose.setVaccineBrand(vaccineBrand);
        dose.setSerialNumber(String.valueOf(UUID.randomUUID()));
        dose.setPatient(patient); //FK mapping in dose class

        patientRepository.save(patient); //atlast save both patient and dose object and return saved dose
        return doseRepository.save(dose);
    }
    
}
