package net.zoungrana.inventoryservice;

import net.zoungrana.inventoryservice.entities.Product;
import net.zoungrana.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args ->{
			Stream.of("Computer","Phone","Watch").forEach((pName)->{
				Product product=Product.builder()
						.name(pName)
						.price(1000+Math.random()*10000)
						.quantity((int)(1+Math.random()*100))
						.build();
				productRepository.save(product);
			});
		};
	}

}
