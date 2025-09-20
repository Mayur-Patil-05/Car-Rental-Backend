package com.mayur.CarRentalSystem.Repositories;

import com.mayur.CarRentalSystem.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}