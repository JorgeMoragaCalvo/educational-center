package com.globant.educationalcenter.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProfessorEntity extends UserEntity {

    private String rut;
    private String department;
    private String courses;
}
