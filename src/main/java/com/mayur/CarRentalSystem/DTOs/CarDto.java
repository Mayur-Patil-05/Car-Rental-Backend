package com.mayur.CarRentalSystem.DTOs;

import com.mayur.CarRentalSystem.Entities.Enums.CarCategory;
import com.mayur.CarRentalSystem.Entities.Enums.FuelType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private Long carId;
    private String brand;
    private String model;
    private Integer year;
    private Double dailyRate;
    private Long seat;
    private CarCategory category;
    private FuelType fuelType;
    private boolean available;
    private List<BookingDto> bookings;
}
