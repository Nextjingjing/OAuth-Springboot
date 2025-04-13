package com.nexty.backend.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserRequestBodyDTO{
    private String fname;
    private String lname;
    private String email;
    private LocalDate birthdate;
}
