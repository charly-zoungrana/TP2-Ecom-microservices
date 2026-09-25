package net.zoungrana.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.zoungrana.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.UUID;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerServiceRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="customer-service",fallbackMethod="getDefaultCustomer")
    Customer findCustomerById(@PathVariable(name="id") UUID customerId);

    @GetMapping("/customers")
    PagedModel<Customer> getAllCustomers();

    default Customer getDefaultCustomer(UUID customerId,Exception exception){
        exception.printStackTrace();
        Customer customer=new Customer();
        customer.setId(customerId);
        customer.setName("Default");
        customer.setEmail("default@gmail.com");
        return customer;
    }
}
