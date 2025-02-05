package com.globant.educationalcenter.controllers;

import com.globant.educationalcenter.converters.StudentConverter;
import com.globant.educationalcenter.dtos.StudentDTO;
import com.globant.educationalcenter.dtos.StudentsActiveDTO;
import com.globant.educationalcenter.entities.StudentEntity;
import com.globant.educationalcenter.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentConverter studentConverter;

    public StudentController(StudentService studentService,
                             StudentConverter studentConverter) {
        this.studentService = studentService;
        this.studentConverter = studentConverter;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> newStudent(@RequestBody StudentDTO studentDTO){
        StudentEntity student = studentConverter.fromDTO(studentDTO);
        StudentEntity savedStudent = studentService.createStudents(student);
        StudentDTO responseDTO = studentConverter.fromEntity(savedStudent);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> deactivateStudents(@PathVariable("id") Long id){
        StudentEntity savedStudent = studentService.deactivateStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(savedStudent);
    }

    @GetMapping("/active")
    public ResponseEntity<List<StudentsActiveDTO>> getActiveStudents(){
        return ResponseEntity.ok(studentService.allStudentsActive());
    }
}
