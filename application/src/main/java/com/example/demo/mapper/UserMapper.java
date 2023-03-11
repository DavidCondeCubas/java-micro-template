package com.example.demo.mapper;

import com.example.demo.application.rest.model.User;
import com.example.demo.models.ModelTest;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "firstName")
    User modelTestToUser(ModelTest user);


}
