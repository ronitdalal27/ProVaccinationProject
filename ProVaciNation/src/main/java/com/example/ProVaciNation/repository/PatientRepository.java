package com.example.ProVaciNation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProVaciNation.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer>{  
    
    
}
