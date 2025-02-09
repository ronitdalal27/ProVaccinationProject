package com.example.ProVaciNation.model;

import com.example.ProVaciNation.Enum.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private boolean vaccinated;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(unique = true,nullable = false)
    private String emailID;

   //default constructor - @NoArgsConstructor
   //parameterized constructor - @AllArgsConstructor
   //Getters and Setters - @Getter and @Setter

}
