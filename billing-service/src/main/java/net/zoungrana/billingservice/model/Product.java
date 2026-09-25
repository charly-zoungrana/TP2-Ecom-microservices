package net.zoungrana.billingservice.model;

import lombok.*;

import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Product {
    private UUID id;
    private String name;
    private double price;
    private int quantity;
}
