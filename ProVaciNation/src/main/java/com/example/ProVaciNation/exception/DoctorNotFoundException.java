package com.example.ProVaciNation.exception;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String msg){
        super(msg);
    }
}
