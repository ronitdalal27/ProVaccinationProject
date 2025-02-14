package com.example.ProVaciNation.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import com.example.ProVaciNation.Enum.VaccineBrand;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serialNumber; //we will use UUID class to generate unique numbers(universely unique indentifier) generate AlphaNUmeric value

    @Enumerated(value = EnumType.STRING)
    private VaccineBrand vaccineBrand;
    
    @CreationTimestamp
    private Date dateOfVaccination;


    @OneToOne //represents dose to patient one-to-one relationship
    @JoinColumn //creates the foreign key -> id of patient table
    Patient patient;
}
