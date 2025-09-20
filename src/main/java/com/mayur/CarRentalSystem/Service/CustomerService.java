package com.mayur.CarRentalSystem.Service;

import com.mayur.CarRentalSystem.DTOs.CustomerDto;
import com.mayur.CarRentalSystem.DTOs.CustomerResponseDto;
import com.mayur.CarRentalSystem.Entities.Customer;
import com.mayur.CarRentalSystem.Exceptions.CustomerNotFoundException;
import com.mayur.CarRentalSystem.Repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public String createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return "Customer created successfully";
    }

    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            throw new CustomerNotFoundException("No customers available");
        }
        return customers.stream().map(customer -> modelMapper.map(customer, CustomerResponseDto.class)).toList();
    }

    public CustomerResponseDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + customerId));
        return modelMapper.map(customer, CustomerResponseDto.class);
    }

    @Transactional
    public String updateCustomer(Long customerId, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + customerId));

        if (customerDto != null) {
            customer.setFirstName(customerDto.getFirstName());
            customer.setLastName(customerDto.getLastName());
            customer.setEmail(customerDto.getEmail());
            customer.setPhone(customerDto.getPhone());
        }
        return "Customer updated successfully.";
    }

    public void deleteCustomer(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new CustomerNotFoundException("Customer not found with id " + customerId);
        }
        customerRepository.deleteById(customerId);
    }
}
