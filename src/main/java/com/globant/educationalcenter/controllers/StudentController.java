package com.globant.educationalcenter.controllers;

import com.globant.educationalcenter.dtos.StudentDTO;
import com.globant.educationalcenter.entities.StudentEntity;
import com.globant.educationalcenter.entities.UserEntity;
import com.globant.educationalcenter.services.StudentService;
import com.globant.educationalcenter.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final UserService userService;

    public StudentController(StudentService studentService, UserService userService) {
        this.studentService = studentService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<StudentEntity> newStudent(@RequestBody StudentDTO studentDTO){
        UserEntity user = new UserEntity();
        user.setFirstname(studentDTO.getFirstname());
        user.setLastname(studentDTO.getLastname());
        user.setRut(studentDTO.getRut());
        user.setEmail(studentDTO.getEmail());
        user.setPassword(studentDTO.getPassword());
        user.setAccountLocked(false);
        user.setEnabled(true);
        user.setRoles(studentDTO.getRoles());

        UserEntity savedUser = userService.createUser(user);

        StudentEntity student = new StudentEntity();
        student.setUser(savedUser);
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        student.setProgram(studentDTO.getProgram());

        StudentEntity savedStudent = studentService.createStudents(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }
}
