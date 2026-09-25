package net.zoungrana.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.zoungrana.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name="INVENTORY-SERVICE")
public interface InventoryServiceRestClient {

    @GetMapping("/products/{id}")
    @CircuitBreaker(name="inventory-service",fallbackMethod ="getDefaultProduct")
    Product findProductById(@PathVariable(name="id") UUID productId);
    @GetMapping("/products")
    PagedModel<Product> getAllProducts();

    default Product getDefaultProduct(UUID productId,Exception exception){
        exception.printStackTrace();

        return Product.builder()
                .id(productId)
                .name("Default")
                .quantity(0)
                .price(0.0)
                .build();
    }
}
