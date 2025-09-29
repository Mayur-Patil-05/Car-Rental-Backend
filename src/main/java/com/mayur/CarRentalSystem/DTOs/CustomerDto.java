package com.mayur.CarRentalSystem.DTOs;

import com.mayur.CarRentalSystem.Entities.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private String phone;
    private List<BookingDto> bookings;
}
