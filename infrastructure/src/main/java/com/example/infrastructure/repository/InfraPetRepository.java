package com.example.infrastructure.repository;

import com.example.infrastructure.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfraPetRepository extends JpaRepository<PetEntity, Long> {
}

