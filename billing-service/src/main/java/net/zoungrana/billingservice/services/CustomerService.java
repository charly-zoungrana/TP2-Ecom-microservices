package net.zoungrana.billingservice.services;

import net.zoungrana.billingservice.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer findCustomerById(UUID id);
}
