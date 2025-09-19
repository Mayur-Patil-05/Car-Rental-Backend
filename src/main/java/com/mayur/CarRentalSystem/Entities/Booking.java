package com.mayur.CarRentalSystem.Entities;

import com.mayur.CarRentalSystem.Entities.Enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double totalCost;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
