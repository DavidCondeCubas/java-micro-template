package com.example.application.rest;

import com.example.application.mapper.PetMapper;
import com.example.domain.ports.inbounds.PetService;
import com.swango.specification.cyt.rest.api.PetsApi;
import com.swango.specification.cyt.rest.model.PetResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PetController implements PetsApi {

    PetService petService;
    PetMapper petMapper;

    public PetController(PetService service, PetMapper petMapper) {
        this.petService = service;
        this.petMapper = petMapper;
    }


    @Override
    public ResponseEntity<List<PetResource>> getPets() {

        return ResponseEntity.ok(
                petService
                        .getPets()
                        .stream()
                        .map(petMapper::petToPetResource)
                        .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<PetResource> addPet(PetResource petResource) {

        return ResponseEntity.ok(
                petMapper.petToPetResource(petService.addPet(petMapper.petResourceToPet(petResource)))
        );
    }
}
