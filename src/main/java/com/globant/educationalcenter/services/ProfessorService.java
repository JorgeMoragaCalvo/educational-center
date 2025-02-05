package com.globant.educationalcenter.services;

import com.globant.educationalcenter.entities.ProfessorEntity;
import com.globant.educationalcenter.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public ProfessorEntity createProfessor(ProfessorEntity professor){
        return professorRepository.save(professor);
    }
}
