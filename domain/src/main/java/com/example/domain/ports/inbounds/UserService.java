package com.example.domain.ports.inbounds;

import com.example.domain.core.models.User;

public interface UserService {
    public User saveUser(User user);
    public User findUser(Long id);
    public User findUserByEmail(String email);
    public User findUserByEmailAndPassword(String email, String password);
}
