package com.example.domain.ports.outbounds;

import com.example.domain.core.models.User;

public interface UserRepository {
    User saveUser(User user);
    User findUser(Long id);
    User findUserByEmail(String email);
    User findUserByEmailAndPassword(String email, String password);
}
