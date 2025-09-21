package com.mayur.CarRentalSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDto {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double totalCost;
//    private CustomerDto customer;
//    private CarDto car;
}
