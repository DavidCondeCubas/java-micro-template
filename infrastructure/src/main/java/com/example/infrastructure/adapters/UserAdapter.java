package com.example.infrastructure.adapters;

import com.example.domain.core.models.User;
import com.example.domain.ports.outbounds.UserRepository;
import com.example.infrastructure.mapper.InfraUserMapper;
import com.example.infrastructure.repository.InfraUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserAdapter implements UserRepository {

    InfraUserRepository infraUserRepository;

    InfraUserMapper infraUserMapper;

    PasswordEncoder passwordEncoder;

    public UserAdapter(InfraUserRepository infraUserRepository, InfraUserMapper infraUserMapper, PasswordEncoder passwordEncoder) {
        this.infraUserRepository = infraUserRepository;
        this.infraUserMapper = infraUserMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user) {
       // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return infraUserMapper.userEntityToUser(infraUserRepository.save(infraUserMapper.userToUserEntity(user)));
    }

    @Override
    public User findUser(Long id) {
        return infraUserMapper.userEntityToUser(infraUserRepository.findById(id).get());
    }

    @Override
    public User findUserByEmail(String email) {
        return infraUserMapper.userEntityToUser(infraUserRepository.findByEmail(email));
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return infraUserMapper.userEntityToUser(
                infraUserRepository.findByEmailAndPassword(email, password)
        );
    }
}
