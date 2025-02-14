package com.example.ProVaciNation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProVaciNation.DTO.Request.PatientRequest;
import com.example.ProVaciNation.DTO.Response.PatientResponse;
import com.example.ProVaciNation.Enum.Gender;
import com.example.ProVaciNation.exception.PatientNotFoundException;
import com.example.ProVaciNation.model.Patient;
import com.example.ProVaciNation.repository.DoctorRepository;
import com.example.ProVaciNation.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    DoctorRepository doctorRepository;

    public PatientResponse addPatient(PatientRequest patientRequest) {

        //convert DDO of PatientRequest to Patient class bcoz patientRepo layer understands only Patient object
        //to convert create the object of patient class and set the desired attributes from patientRequest object of PatientRequest class
        Patient patient = new Patient();
        patient.setVaccinated(false);
        patient.setName(patientRequest.getName());
        patient.setGender(patientRequest.getGender());
        patient.setAge(patientRequest.getAge());
        patient.setEmailID(patientRequest.getEmailID());

        //save the patient object to patient Repository
        Patient savedPatient = patientRepository.save(patient);

        //convert of model entity i.e. savedPatient to PatientResponse 
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(savedPatient.getName());
        patientResponse.setEmailID(savedPatient.getEmailID());
        patientResponse.setVaccinated(savedPatient.isVaccinated());

        return patientResponse;
    }

    public PatientResponse getPatient(int id) {
       Optional<Patient> optionalPatient =  patientRepository.findById(id); //this id is PK

       if(optionalPatient.isEmpty()){
            throw new PatientNotFoundException("Invalid Patient Id");
       }

       Patient patient = optionalPatient.get();

       PatientResponse patientResponse = new PatientResponse();
       patientResponse.setName(patient.getName());
       patientResponse.setEmailID(patient.getEmailID());
       patientResponse.setVaccinated(patient.isVaccinated());

       return patientResponse;
    }

    public List<PatientResponse> getSpecificGenderPatients(Gender gender) {
        //find all the patients first
        List<Patient> patients = patientRepository.findAll();

        List<PatientResponse> patientList = new ArrayList<>();
        for(Patient p : patients){
            if(p.getGender()==gender){
                PatientResponse patientResponse = new PatientResponse();
                patientResponse.setName(p.getName());
                patientResponse.setEmailID(p.getEmailID());
                patientResponse.setVaccinated(p.isVaccinated());
                patientList.add(patientResponse);
            }
        }

        return patientList;
    }
}
