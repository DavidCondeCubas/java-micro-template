package com.example.domain.ports.inbounds;

import com.example.domain.core.models.Pet;

import java.util.List;

public interface PetService {

    public List<Pet> getPets();
}
