package com.example.ProVaciNation.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProVaciNation.DTO.Response.AppointmentResponse;
import com.example.ProVaciNation.DTO.Response.PatientResponse;
import com.example.ProVaciNation.Enum.AppointmentStatus;
import com.example.ProVaciNation.exception.DoctorNotFoundException;
import com.example.ProVaciNation.exception.PatientNotFoundException;
import com.example.ProVaciNation.model.Appointment;
import com.example.ProVaciNation.model.Doctor;
import com.example.ProVaciNation.model.Patient;
import com.example.ProVaciNation.repository.AppointmentRepository;
import com.example.ProVaciNation.repository.DoctorRepository;
import com.example.ProVaciNation.repository.PatientRepository;

@Service
public class AppointmentService {

    @Autowired 
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentResponse bookAppointment(int patientID, int doctorID) {
        
        Optional<Patient> optionalPatient = patientRepository.findById(patientID);
        if(optionalPatient.isEmpty())
            throw new PatientNotFoundException("patient Not found Exception");

        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorID);
        if(optionalDoctor.isEmpty())
            throw new DoctorNotFoundException("Doctor Not found Exception");

        Patient patient = optionalPatient.get();
        Doctor doctor = optionalDoctor.get();


        Appointment appointment = new Appointment();

        appointment.setAppointmntId(String.valueOf(UUID.randomUUID()));
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);    

        Appointment savedAppointment =  appointmentRepository.save(appointment);
        //convert your model to response ATO i.e. savedAppointment to appointmentResponse
        AppointmentResponse appointmentResponse = new AppointmentResponse(); //save all the needed feilds of appointmentResponse 
        appointmentResponse.setAppointmntId(savedAppointment.getAppointmntId());
        appointmentResponse.setDateofAppointment(savedAppointment.getDateofAppointment());
        appointmentResponse.setStatus(savedAppointment.getStatus());
        appointmentResponse.setDoctorName(savedAppointment.getDoctor().getName());

        //this thing is to saved PatientResponse object in AppointmentResponse
        Patient savedPatient = savedAppointment.getPatient(); //why savedPatient object created ? coz we want to save patientResponse object which is present in AppointmentResponse

        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(savedPatient.getName());
        patientResponse.setEmailID(savedPatient.getEmailID());
        patientResponse.setVaccinated(savedPatient.isVaccinated());

        appointmentResponse.setPatientResponse(patientResponse);

        return appointmentResponse;
    }
}


/*
    logic of bookAppointment API 
        first check whether patientiD and doctorID are correct if not so throw exceptions accordingly
        if they are correct so extract object of patient and doctor from get() method
        and finally book the appointment , how to book ?
            make appointment object first
            now we are writting logic so first see how many entities are involved,here 3 Appointmnet,Doctor n Patient
            now go through each entity see what attributes we have to set,what attributes user will give input for,and what attributes database will provide input automatically
            there is no need to set Patient and Doctor but we have to set Appointment's object many attributes
            as we are not doing any change to patient and doctor so no need to save their object in their respective repo's in the end
            but we are updating appointment's object so save in that repos
 */
