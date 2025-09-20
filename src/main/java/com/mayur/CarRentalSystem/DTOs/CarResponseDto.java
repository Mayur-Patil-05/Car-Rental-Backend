package com.mayur.CarRentalSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarResponseDto {
    private String brand;
    private String model;
    private Integer year;
    private Double dailyRate;
    private boolean available;
}
