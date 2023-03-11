package com.example.demo.config;

import com.example.demo.InfraPorts.RepositoryTest;
import com.example.demo.adapters.RespositoryTestImp;
import com.example.demo.ports.Service;
import com.example.demo.ports.ServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfraConfirguration {

    @Bean
    public RepositoryTest newAdapter(){
        return new RespositoryTestImp();
    }
}
