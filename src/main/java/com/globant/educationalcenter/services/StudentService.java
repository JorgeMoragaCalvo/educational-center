package com.globant.educationalcenter.services;

import com.globant.educationalcenter.entities.StudentEntity;
import com.globant.educationalcenter.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity createStudents(StudentEntity student){
        return studentRepository.save(student);
    }
}
