package com.example.infrastructure.mapper;

import com.example.domain.core.models.Pet;
import com.example.infrastructure.entity.PetEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InfraPetMapper {
    Pet petEntityToPet(PetEntity petEntity);
}
