package com.example.infrastructure.adapters;


import com.example.domain.core.models.Pet;
import com.example.domain.ports.outbounds.PetRepository;
import com.example.infrastructure.mapper.InfraPetMapper;
import com.example.infrastructure.repository.InfraPetRepository;

import java.util.List;
import java.util.stream.Collectors;

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
                .collect(Collectors.toList());
    }
}
