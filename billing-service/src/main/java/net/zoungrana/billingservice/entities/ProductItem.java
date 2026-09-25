package net.zoungrana.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import net.zoungrana.billingservice.model.Product;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID productId;
    private int quantity;
    private double price;
    private double discount;
    @ManyToOne
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    @Transient
    private Product product;
}
