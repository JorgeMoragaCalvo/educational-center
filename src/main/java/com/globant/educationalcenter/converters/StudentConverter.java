package com.globant.educationalcenter.converters;

import com.globant.educationalcenter.dtos.StudentDTO;
import com.globant.educationalcenter.entities.StudentEntity;
import com.globant.educationalcenter.entities.UserEntity;
import com.globant.educationalcenter.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter extends AbstractConverter<StudentEntity, StudentDTO> {

    private final UserService userService;

    public StudentConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public StudentEntity fromDTO(StudentDTO dto) {
        UserEntity user = UserEntity.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .rut(dto.getRut())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .active(true)
                .accountLocked(false)
                .enabled(true)
                .roles(dto.getRoles())
                .build();

        UserEntity savedUser = userService.createUser(user);

        return StudentEntity.builder()
                .user(savedUser)
                .dateOfBirth(dto.getDateOfBirth())
                .program(dto.getProgram())
                .build();
    }

    @Override
    public StudentDTO fromEntity(StudentEntity entity) {
        return StudentDTO.builder()
                .firstname(entity.getUser().getFirstname())
                .lastname(entity.getUser().getLastname())
                .rut(entity.getUser().getRut())
                .email(entity.getUser().getEmail())
                .roles(entity.getUser().getRoles())
                .dateOfBirth(entity.getDateOfBirth())
                .program(entity.getProgram())
                .build();
    }
}
