package com.mayur.CarRentalSystem.Repositories;

import com.mayur.CarRentalSystem.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}