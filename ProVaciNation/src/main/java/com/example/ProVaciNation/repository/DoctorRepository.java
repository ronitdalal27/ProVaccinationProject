package com.example.ProVaciNation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProVaciNation.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer>{
    
}
