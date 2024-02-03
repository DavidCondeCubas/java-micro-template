package com.example.domain.core;


import com.example.domain.core.models.User;
import com.example.domain.ports.inbounds.UserService;
import com.example.domain.ports.outbounds.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    @Override
    public User findUser(Long id) {
        return userRepository.findUser(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }
}
