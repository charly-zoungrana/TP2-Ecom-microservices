package net.zoungrana.billingservice;

import net.zoungrana.billingservice.entities.Bill;
import net.zoungrana.billingservice.entities.ProductItem;
import net.zoungrana.billingservice.model.Customer;
import net.zoungrana.billingservice.model.Product;
import net.zoungrana.billingservice.repository.BillRepository;
import net.zoungrana.billingservice.repository.ProductItemRepository;
import net.zoungrana.billingservice.services.CustomerService;
import net.zoungrana.billingservice.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository billRepository,
							ProductItemRepository productItemRepository,
							CustomerService customerService,
							ProductService productService){

		return args ->{

			List<UUID> customerIds=customerService.getAllCustomers()
					.stream()
					.map(Customer::getId)
					.toList();

			List<UUID> productIds=productService.getAllProducts()
					.stream()
					.map(Product::getId)
					.toList();

			customerIds.forEach(customerId->{
				Bill bill=Bill.builder()
						.customerId(customerId)
						.billingDate(LocalDate.now())
						.build();
				billRepository.save(bill);

				productIds.forEach(productId->{
					ProductItem productItem= ProductItem.builder()
							.productId(productId)
							.bill(bill)
							.price(100+Math.random()*1000)
							.quantity(1+ new Random().nextInt(20))
							.build();
					productItemRepository.save(productItem);
				});
			});
		};

	}
}
