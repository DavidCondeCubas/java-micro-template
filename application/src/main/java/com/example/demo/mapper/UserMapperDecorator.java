package com.example.demo.mapper;

import com.example.demo.application.rest.model.User;
import com.example.demo.models.ModelTest;

public abstract class UserMapperDecorator implements UserMapper{

    private final UserMapper delegate;

    public UserMapperDecorator(UserMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public User modelTestToUser(ModelTest modelTest) {
        User user = delegate.modelTestToUser(modelTest);
        user.setFirstName(user.getFirstName()+ " | 2- received from service");
        return user;
    }
}
