package com.example.ProVaciNation.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientResponse {
    
    private String name;
    private boolean vaccinated;
    private String emailID;

}
