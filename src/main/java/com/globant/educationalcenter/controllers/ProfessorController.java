package com.globant.educationalcenter.controllers;

import com.globant.educationalcenter.converters.ProfessorConverter;
import com.globant.educationalcenter.dtos.ProfessorDTO;
import com.globant.educationalcenter.entities.ProfessorEntity;
import com.globant.educationalcenter.services.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService professorService;
    private final ProfessorConverter professorConverter;

    public ProfessorController(ProfessorService professorService, ProfessorConverter professorConverter) {
        this.professorService = professorService;
        this.professorConverter = professorConverter;
    }

    @PostMapping
    public ResponseEntity<ProfessorDTO> createNewProfessor(@RequestBody ProfessorDTO professorDTO){
        ProfessorEntity professor = professorConverter.fromDTO(professorDTO);
        ProfessorEntity savedProfessor = professorService.createProfessor(professor);
        ProfessorDTO responseDTO = professorConverter.fromEntity(savedProfessor);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
