package com.example.ProVaciNation.DTO.Response;

import java.sql.Date;

import com.example.ProVaciNation.Enum.AppointmentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppointmentResponse {
    private String appointmntId;
    
    private Date dateofAppointment;

    private AppointmentStatus status;

    private PatientResponse patientResponse; 

    private String doctorName; //doctor name
}
