package com.globant.educationalcenter.services;

import com.globant.educationalcenter.entities.UserEntity;
import com.globant.educationalcenter.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user){
        return userRepository.save(user);
    }
}
