package com.example.ProVaciNation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProVaciNation.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{    
    
}
