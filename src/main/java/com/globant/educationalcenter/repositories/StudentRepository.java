package com.globant.educationalcenter.repositories;

import com.globant.educationalcenter.entities.StudentEntity;
import com.globant.educationalcenter.entities.UserEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @NonNull
    @Query("select s from StudentEntity s join fetch s.user where s.id = :id")
    Optional<StudentEntity> findById(@NonNull Long id);

    @Query("select u, s.program from StudentEntity s join s.user u where u.active = true")
    List<Object[]> findAllByUserActive();
}
