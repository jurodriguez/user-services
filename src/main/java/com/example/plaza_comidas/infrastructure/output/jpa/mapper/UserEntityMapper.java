package com.example.plaza_comidas.infrastructure.output.jpa.mapper;

import com.example.plaza_comidas.domain.model.User;
import com.example.plaza_comidas.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    UserEntity toEntity(User user);

    User toUser(UserEntity userEntity);

    List<User> toUsuarioList(List<UserEntity> userEntityList);
}
