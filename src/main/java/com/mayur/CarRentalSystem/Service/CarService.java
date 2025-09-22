package com.mayur.CarRentalSystem.Service;

import com.mayur.CarRentalSystem.DTOs.CarDto;
import com.mayur.CarRentalSystem.DTOs.CarResponseDto;
import com.mayur.CarRentalSystem.Entities.Car;
import com.mayur.CarRentalSystem.Exceptions.CarNotFoundException;
import com.mayur.CarRentalSystem.Repositories.CarRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public String addCar(CarDto carDto) {
        Car car = modelMapper.map(carDto, Car.class);
        Car savedCar = carRepository.save(car);
        return "Car added successfully";
    }

    public List<CarResponseDto> getAllCars() {
        List<Car> cars = carRepository.findAll();
        if (cars.isEmpty()){
            throw new CarNotFoundException("Cars not available");
        }
        return cars.stream().map(car -> modelMapper.map(car, CarResponseDto.class)).toList();
    }

    public CarResponseDto getCarById(Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id " + carId));
        return modelMapper.map(car, CarResponseDto.class);
    }

    @Transactional
    public String updateCar(Long carId, CarDto carDto) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id " + carId));

        if (carDto != null) {
            car.setBrand(carDto.getBrand());
            car.setModel(carDto.getModel());
            car.setYear(carDto.getYear());
            car.setDailyRate(carDto.getDailyRate());
            car.setSeat(carDto.getSeat());
            car.setCategory(carDto.getCategory());
            car.setFuelType(carDto.getFuelType());
            car.setAvailable(carDto.isAvailable());
        }

        return "Car updated successfully";
    }


    public void deleteCar(Long carId) {
        if (!carRepository.existsById(carId)) {
            throw new CarNotFoundException("Car not found with id " + carId);
        }
        carRepository.deleteById(carId);
    }
}
