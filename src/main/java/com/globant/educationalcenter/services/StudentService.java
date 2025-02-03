package com.globant.educationalcenter.services;

import com.globant.educationalcenter.entities.StudentEntity;
import com.globant.educationalcenter.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity createStudents(StudentEntity student){
        return studentRepository.save(student);
    }

    public StudentEntity deactivateStudent(Long id){
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        student.getUser().setActive(false);
        student.getUser().setDeletedAt(LocalDateTime.now());

        return student;
    }
}
