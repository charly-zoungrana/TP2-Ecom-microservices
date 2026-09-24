package net.zoungrana.customerservice;

import net.zoungrana.customerservice.entities.Customer;
import net.zoungrana.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args ->{
				Stream.of("Charly","Phanuel","Lucas").forEach((name) -> {
					Customer customer=Customer.builder()
							.name(name)
							.email(name+"@gmail.com")
							.build();
					customerRepository.save(customer);
				});
		};
	}

}
