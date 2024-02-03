package com.example.application.rest;


import com.example.application.mapper.UserMapper;
import com.example.domain.ports.inbounds.UserService;
import com.swango.specification.cyt.rest.api.UsersApi;
import com.swango.specification.cyt.rest.model.UserResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController implements UsersApi {

    UserService userService;
    UserMapper userMapper;

    public UserController(UserService service, UserMapper userMapper) {
        this.userService = service;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<UserResource> addUser(UserResource userResource) {
        return ResponseEntity.ok(userMapper.userToUserResource(userService.saveUser(userMapper.userResourceToUser(userResource))));
    }

    @Override
    public ResponseEntity<UserResource> getUserById(Long userId) {
        return ResponseEntity.ok(userMapper.userToUserResource(userService.findUser(userId)));
    }
}
