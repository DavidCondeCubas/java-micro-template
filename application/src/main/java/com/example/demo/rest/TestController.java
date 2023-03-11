package com.example.demo.rest;

import com.example.demo.application.rest.api.UserApi;
import com.example.demo.application.rest.model.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.ModelTest;
import com.example.demo.ports.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements UserApi {

    @Autowired
    Service service;

    @GetMapping
    public String asdas(){
        return "hola mundo desde application module";
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public User test(){
        return new User().id(1L).firstName(String.format("override for username: %s","TEs2222tUSER"));
    }
    @Override
    public ResponseEntity<User> getUserByName
            (String username) {
        ModelTest modelTest = new ModelTest();
        modelTest.setName(String.format("1- Created from user %s in app",username));

        return ResponseEntity.ok(UserMapper.INSTANCE.modelTestToUser(modelTest));
    }

}
