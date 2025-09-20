package com.mayur.CarRentalSystem.Controllers;

import com.mayur.CarRentalSystem.DTOs.CarDto;
import com.mayur.CarRentalSystem.DTOs.CarResponseDto;
import com.mayur.CarRentalSystem.Service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addCar(@RequestBody CarDto carDto) {
        return carService.addCar(carDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CarResponseDto> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{carId}")
    @ResponseStatus(HttpStatus.OK)
    public CarResponseDto getCarById(@PathVariable Long carId) {
        return carService.getCarById(carId);
    }

    @PutMapping("/{carId}")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateCar(@PathVariable Long carId, @RequestBody CarDto carDto) {
        return carService.updateCar(carId, carDto);
    }

    @DeleteMapping("/{carId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable Long carId) {
        carService.deleteCar(carId);
    }
}
