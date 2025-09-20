package com.mayur.CarRentalSystem.Repositories;

import com.mayur.CarRentalSystem.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}