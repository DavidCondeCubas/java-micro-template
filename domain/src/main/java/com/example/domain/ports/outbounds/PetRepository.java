package com.example.domain.ports.outbounds;

import com.example.domain.core.models.Pet;

import java.util.List;

public interface PetRepository {
    List<Pet> getPets();
}
