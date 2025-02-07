package com.globant.educationalcenter.repositories;

import com.globant.educationalcenter.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByActiveTrue();

    List<UserEntity> findAllByActiveFalse();

    Optional<UserEntity> findByEmail(String email);
}
