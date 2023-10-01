package com.example.order.management.system.service;

import com.example.order.management.system.entity.Customer;
import com.example.order.management.system.exception.ResourceNotFoundException;
import com.example.order.management.system.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer, long id) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer", id, "id"));
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setTelephone(customer.getTelephone());
        existingCustomer.setFullName(customer.getFullName());
        existingCustomer.setRegistrationCode(customer.getRegistrationCode());
        existingCustomer.setPurchaseOrders(customer.getPurchaseOrders());
        customerRepository.save(existingCustomer);
        return existingCustomer;
    }

    public void deleteCustomer(long id) {
        customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer", id, "id"));
        customerRepository.deleteById(id);
    }

    public Customer getCustomerById(long id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer", id, "id"));
    }
}
