package com.example.domain.core;

import com.example.domain.ports.outbounds.PetRepository;
import com.example.domain.ports.inbounds.PetService;
import com.example.domain.core.models.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImp implements PetService {

    PetRepository petRespository;

    public PetServiceImp(PetRepository repositoryTest) {
        this.petRespository = repositoryTest;
    }

    @Override
    public List<Pet> getPets() {

        return petRespository.getPets();
       // throw new RuntimeException("Error en el sistema");
    }

    @Override
    public Pet addPet(Pet pet) {
        return petRespository.savePet(pet);
    }
}
