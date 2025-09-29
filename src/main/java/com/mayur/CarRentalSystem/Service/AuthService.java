package com.mayur.CarRentalSystem.Service;

import com.mayur.CarRentalSystem.DTOs.LoginRequestDto;
import com.mayur.CarRentalSystem.DTOs.LoginResponseDto;
import com.mayur.CarRentalSystem.Entities.Customer;
import com.mayur.CarRentalSystem.Security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword())
            );

            Customer customer = (Customer) authentication.getPrincipal();
            String token = jwtUtil.generateAccessToken(customer);

            return new LoginResponseDto(token, customer.getCustomerId(), customer.getFirstName());

        } catch (Exception ex) {
            System.out.println("Login failed: " + ex.getMessage());
            throw ex;
        }
    }
}
