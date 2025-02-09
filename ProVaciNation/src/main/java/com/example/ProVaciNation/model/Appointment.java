package com.example.ProVaciNation.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.example.ProVaciNation.Enum.AppointmentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String appointmntId; //no need to take from user will be set using UUID class
    
    @CreationTimestamp
    private Date dateofAppointment;

    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus status;

    @ManyToOne //many to one bcoz appointment class is Many side and doctor is one side
    @JoinColumn
    Doctor doctor;

    @OneToOne //First one represents appointment class and second one represents patient class
    @JoinColumn 
    Patient patient;
}
