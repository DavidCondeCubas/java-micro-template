package com.example.infrastructure.repository;

import com.example.infrastructure.entity.PetEntity;
import com.example.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfraUserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByEmailAndPassword(String email, String password);
}

