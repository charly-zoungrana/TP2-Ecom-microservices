package net.zoungrana.billingservice.services;

import net.zoungrana.billingservice.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();
    Product findProductById(UUID id);
}
