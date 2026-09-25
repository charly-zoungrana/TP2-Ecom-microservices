package net.zoungrana.billingservice.services;

import lombok.RequiredArgsConstructor;
import net.zoungrana.billingservice.feign.CustomerServiceRestClient;
import net.zoungrana.billingservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerServiceRestClient customerServiceRestClient;
    @Override
    public List<Customer> getAllCustomers() {

        return new ArrayList<>(customerServiceRestClient.getAllCustomers().getContent());
    }

    @Override
    public Customer findCustomerById(UUID id) {
        return customerServiceRestClient.findCustomerById(id);
    }
}
