package com.example.plaza_comidas.application.handler;

import com.example.plaza_comidas.application.dto.UserRequest;
import com.example.plaza_comidas.application.dto.UserResponse;
import jakarta.validation.Valid;

public interface IUserHandler {

    void saveUserInUsers(@Valid UserRequest userRequest);

    UserResponse getUserById(Long id);

}
