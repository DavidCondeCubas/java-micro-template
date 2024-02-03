package com.example.application.mapper;

import com.example.domain.core.models.User;
import com.swango.specification.cyt.rest.model.UserResource;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserResource userToUserResource(User user);

    User userResourceToUser(UserResource userResource);
}
