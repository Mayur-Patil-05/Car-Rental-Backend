package com.mayur.CarRentalSystem.Controllers;

import com.mayur.CarRentalSystem.DTOs.CustomerDto;
import com.mayur.CarRentalSystem.DTOs.LoginRequestDto;
import com.mayur.CarRentalSystem.DTOs.LoginResponseDto;
import com.mayur.CarRentalSystem.Service.AuthService;
import com.mayur.CarRentalSystem.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final CustomerService customerService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return authService.login(loginRequestDto);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerClient(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }
}
