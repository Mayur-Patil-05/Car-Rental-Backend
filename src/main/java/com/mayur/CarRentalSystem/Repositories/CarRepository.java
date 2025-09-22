package com.mayur.CarRentalSystem.Repositories;

import com.mayur.CarRentalSystem.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByAvailableTrue();
}