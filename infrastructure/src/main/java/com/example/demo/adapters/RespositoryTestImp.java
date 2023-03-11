package com.example.demo.adapters;


import com.example.demo.InfraPorts.RepositoryTest;


public class RespositoryTestImp implements RepositoryTest {
    @Override
    public void saveName(String name) {
        System.out.println("Se llego hasta capa de infra");
    }
}
