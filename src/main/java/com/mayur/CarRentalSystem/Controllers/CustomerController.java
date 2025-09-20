package com.mayur.CarRentalSystem.Controllers;

import com.mayur.CarRentalSystem.DTOs.CustomerDto;
import com.mayur.CarRentalSystem.DTOs.CustomerResponseDto;
import com.mayur.CarRentalSystem.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponseDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponseDto getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}
