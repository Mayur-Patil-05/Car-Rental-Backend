package com.mayur.CarRentalSystem.Controllers;

import com.mayur.CarRentalSystem.DTOs.BookingDto;
import com.mayur.CarRentalSystem.DTOs.BookingResponseDto;
import com.mayur.CarRentalSystem.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.createBooking(bookingDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookingResponseDto> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PutMapping("/{carId}")
    @ResponseStatus(HttpStatus.OK)
    public void cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
    }
}
