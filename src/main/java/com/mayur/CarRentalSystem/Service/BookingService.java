package com.mayur.CarRentalSystem.Service;

import com.mayur.CarRentalSystem.DTOs.BookingDto;
import com.mayur.CarRentalSystem.DTOs.BookingResponseDto;
import com.mayur.CarRentalSystem.Entities.Booking;
import com.mayur.CarRentalSystem.Entities.Car;
import com.mayur.CarRentalSystem.Entities.Customer;
import com.mayur.CarRentalSystem.Entities.Enums.BookingStatus;
import com.mayur.CarRentalSystem.Exceptions.BookingNotFoundException;
import com.mayur.CarRentalSystem.Exceptions.CarNotFoundException;
import com.mayur.CarRentalSystem.Exceptions.CustomerNotFoundException;
import com.mayur.CarRentalSystem.Repositories.BookingRepository;
import com.mayur.CarRentalSystem.Repositories.CarRepository;
import com.mayur.CarRentalSystem.Repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public String createBooking(BookingDto bookingDto) {
        Car car = carRepository.findById(bookingDto.getCar().getCarId())
                .orElseThrow(() -> new CarNotFoundException("Car not found with id " + bookingDto.getCar().getCarId()));

        Customer customer = customerRepository.findById(bookingDto.getCustomer().getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + bookingDto.getCustomer().getCustomerId()));

        Booking booking = new Booking();
        booking.setCar(car);
        booking.setCustomer(customer);
        booking.setStartDate(bookingDto.getStartDate());
        booking.setEndDate(bookingDto.getEndDate());
        booking.setStatus(BookingStatus.PENDING);

        long days = ChronoUnit.DAYS.between(bookingDto.getStartDate(), bookingDto.getEndDate());
        booking.setTotalCost(days * car.getDailyRate());
        car.setAvailable(false);
        carRepository.save(car);

        Booking savedBooking = bookingRepository.save(booking);
        return "Booking done bro";
    }

    public List<BookingResponseDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(booking -> modelMapper.map(booking, BookingResponseDto.class)).toList();
    }

    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with id " + id));
        booking.setStatus(BookingStatus.CANCELLED);

        Car car = booking.getCar();
        car.setAvailable(true);
        carRepository.save(car);
        bookingRepository.save(booking);
    }
}
