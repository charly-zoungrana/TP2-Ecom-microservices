package net.zoungrana.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.zoungrana.billingservice.model.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate billingDate;
    private UUID customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}
