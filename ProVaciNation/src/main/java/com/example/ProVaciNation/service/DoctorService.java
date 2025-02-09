package com.example.ProVaciNation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProVaciNation.exception.DoctorNotFoundException;
import com.example.ProVaciNation.model.Doctor;
import com.example.ProVaciNation.repository.DoctorRepository;

@Service
public class DoctorService {
    
    @Autowired
    DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return "doctor added successfully !!!";
    }

    public Doctor getDoctor(int id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);

        if(optionalDoctor.isEmpty())
            throw new DoctorNotFoundException("invalid doctor id,doctor not found !!!");

        Doctor doctor = optionalDoctor.get();
        return doctor;
    }

    public String deleteDoctor(int id) {
        doctorRepository.deleteById(id); 
        return "doctor has been deleted !!!";
    }
    
}
