package net.zoungrana.customerservice.repository;

import net.zoungrana.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}