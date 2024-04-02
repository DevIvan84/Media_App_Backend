package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDTO {

    private Integer idPatient;

    private String firstName;


    private String lastName;


    private String dni;


    private String address;


    private String phone;


    private String email;
}
