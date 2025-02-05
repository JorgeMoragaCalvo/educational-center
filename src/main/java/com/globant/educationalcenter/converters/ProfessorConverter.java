package com.globant.educationalcenter.converters;

import com.globant.educationalcenter.dtos.ProfessorDTO;
import com.globant.educationalcenter.entities.ProfessorEntity;
import com.globant.educationalcenter.entities.UserEntity;
import com.globant.educationalcenter.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class ProfessorConverter extends AbstractConverter<ProfessorEntity, ProfessorDTO>{

    private final UserService  userService;

    public ProfessorConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ProfessorDTO fromEntity(ProfessorEntity entity) {
        return ProfessorDTO.builder()
                .firstname(entity.getUser().getFirstname())
                .lastname(entity.getUser().getLastname())
                .rut(entity.getUser().getRut())
                .email(entity.getUser().getEmail())
                .roles(entity.getUser().getRoles())
                .category(entity.getCategory())
                .department(entity.getDepartment())
                .officeNumber(entity.getOfficeNumber())
                .build();
    }

    @Override
    public ProfessorEntity fromDTO(ProfessorDTO dto) {
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
        return ProfessorEntity.builder()
                .user(savedUser)
                .category(dto.getCategory())
                .department(dto.getDepartment())
                .officeNumber(dto.getOfficeNumber())
                .build();
    }
}
