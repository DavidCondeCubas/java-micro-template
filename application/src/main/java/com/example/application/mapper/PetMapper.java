package com.example.application.mapper;


import com.example.domain.core.models.Pet;
import com.swango.specification.cyt.rest.model.PetResource;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PetMapper {

    PetResource petToPetResource(Pet pet);

    Pet petResourceToPet(PetResource pet);
}
