package net.zoungrana.billingservice.model;

import lombok.*;

import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {
    private UUID id;
    private String name;
    private String email;
}
