package com.example.infrastructure.config;

import com.example.domain.ports.outbounds.PetRepository;
import com.example.infrastructure.adapters.PetAdapter;
import com.example.infrastructure.mapper.InfraPetMapper;
import com.example.infrastructure.repository.InfraPetRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfraConfiguration {

    @Bean
    public PetRepository newAdapter(InfraPetRepository infraPetRepository, InfraPetMapper infraPetMapper){
        return new PetAdapter(infraPetRepository, infraPetMapper);
    }
}
