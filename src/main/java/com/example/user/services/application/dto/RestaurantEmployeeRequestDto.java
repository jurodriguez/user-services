package com.example.user.services.application.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RestaurantEmployeeRequestDto {

    @NotNull(message = "The restaurant id is required")
    private Long restaurantId;
    @NotNull(message = "The employee id is required")
    private Long employeeId;
}
