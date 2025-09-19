package com.mayur.CarRentalSystem.DTOs;

import com.mayur.CarRentalSystem.Entities.Enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Long bookingId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double totalCost;
    private BookingStatus status;
    private CustomerDto customer;
    private CarDto car;
}
