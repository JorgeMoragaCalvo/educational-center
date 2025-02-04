package com.globant.educationalcenter.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentsActiveDTO {

    private String firstname;
    private String lastname;
    private String rut;
    private String email;
    private String program;
}
