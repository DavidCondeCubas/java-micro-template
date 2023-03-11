package com.example.demo.ports;

import com.example.demo.InfraPorts.RepositoryTest;
import com.example.demo.models.ModelTest;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImp implements Service{

    RepositoryTest repositoryTest;

    public ServiceImp(RepositoryTest repositoryTest) {
        this.repositoryTest = repositoryTest;
    }

    @Override
    public String getName(ModelTest modelTest) {
        repositoryTest.saveName(modelTest.getName());
        return modelTest.getName();
    }
}
