package com.example.infrastructure.mapper;

import com.example.domain.core.models.User;
import com.example.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InfraUserMapper {
    User userEntityToUser(UserEntity petEntity);
    UserEntity userToUserEntity(User user);
}
