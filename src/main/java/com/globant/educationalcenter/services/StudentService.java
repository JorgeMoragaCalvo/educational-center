package com.globant.educationalcenter.services;

import com.globant.educationalcenter.dtos.StudentsActiveDTO;
import com.globant.educationalcenter.entities.StudentEntity;
import com.globant.educationalcenter.entities.UserEntity;
import com.globant.educationalcenter.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity createStudents(StudentEntity student) {
        return studentRepository.save(student);
    }

    public StudentEntity deactivateStudent(Long id) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        student.getUser().setActive(false);
        student.getUser().setDeletedAt(LocalDateTime.now());

        return student;
    }

    public List<StudentsActiveDTO> allStudentsActive() {
        List<Object[]> results = studentRepository.findAllByUserActive();

        return results.stream()
                .map(result -> {
                    UserEntity user = (UserEntity) result[0];
                    String program = (String) result[1];

                    return new StudentsActiveDTO(
                            user.getFirstname(),
                            user.getLastname(),
                            user.getRut(),
                            user.getEmail(),
                            program
                    );
                })
                .collect(Collectors.toList());
    }
}