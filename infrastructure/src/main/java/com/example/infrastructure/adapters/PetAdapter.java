package com.example.infrastructure.adapters;


import com.example.domain.core.models.Pet;
import com.example.domain.ports.outbounds.PetRepository;
import com.example.infrastructure.entity.PetEntity;
import com.example.infrastructure.mapper.InfraPetMapper;
import com.example.infrastructure.repository.InfraPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PetAdapter implements PetRepository {

    InfraPetRepository infraPetRepository;
    InfraPetMapper infraPetMapper;

    public PetAdapter(InfraPetRepository infraPetRepository, InfraPetMapper infraPetMapper) {
        this.infraPetRepository = infraPetRepository;
        this.infraPetMapper = infraPetMapper;
    }

    @Override
    public List<Pet> getPets() {
        return infraPetRepository
                .findAll()
                .stream()
                .map(infraPetMapper::petEntityToPet)
                .toList();
    }

    @Override
    public Pet savePet(Pet pet) {
        PetEntity petEntity = infraPetRepository.save(infraPetMapper.petToPetEntity(pet));
        return infraPetMapper.petEntityToPet(petEntity);
    }
}
