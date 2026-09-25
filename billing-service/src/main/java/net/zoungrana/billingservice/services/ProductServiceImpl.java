package net.zoungrana.billingservice.services;

import lombok.RequiredArgsConstructor;
import net.zoungrana.billingservice.feign.InventoryServiceRestClient;
import net.zoungrana.billingservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final InventoryServiceRestClient inventoryServiceRestClient;
    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(inventoryServiceRestClient.getAllProducts().getContent());
    }

    @Override
    public Product findProductById(UUID id) {
        return inventoryServiceRestClient.findProductById(id);
    }
}
