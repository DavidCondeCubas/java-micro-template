package com.example.domain.config;

import com.example.domain.core.PetServiceImp;
import com.example.domain.ports.inbounds.PetService;
import com.example.domain.ports.outbounds.PetRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfirguration {

    @Bean
    PetService configPetService(PetRepository petRepository){
        return new PetServiceImp(petRepository);
    }
}
