package com.globant.educationalcenter.initializer;

import com.globant.educationalcenter.repositories.RoleRepository;
import com.globant.educationalcenter.roles.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    // Class to create automatically Roles in database

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(roleRepository.findByName("ROLE_ADMIN").isEmpty()){
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }

        if(roleRepository.findByName("ROLE_PROFESSOR").isEmpty()){
            Role professorRole = new Role();
            professorRole.setName("ROLE_PROFESSOR");
            roleRepository.save(professorRole);
        }

        if(roleRepository.findByName("ROLE_STUDENT").isEmpty()){
            Role studentRole = new Role();
            studentRole.setName("ROLE_STUDENT");
            roleRepository.save(studentRole);
        }
    }
}
