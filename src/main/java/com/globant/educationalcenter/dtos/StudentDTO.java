package com.globant.educationalcenter.dtos;

import com.globant.educationalcenter.roles.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
public class StudentDTO {

    private String firstname;
    private String lastname;
    private String rut;
    private String email;
    private String password;
    private boolean active;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
    private Set<Role> roles;
    private LocalDate dateOfBirth;
    private String program;
}
