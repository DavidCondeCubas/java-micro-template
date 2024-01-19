package com.example.domain.core;

import com.example.domain.ports.outbounds.PetRepository;
import com.example.domain.ports.inbounds.PetService;
import com.example.domain.core.models.Pet;

import java.util.List;

public class PetServiceImp implements PetService {

    PetRepository repositoryTest;

    public PetServiceImp(PetRepository repositoryTest) {
        this.repositoryTest = repositoryTest;
    }

    @Override
    public List<Pet> getPets() {
        return repositoryTest.getPets();
    }
}
