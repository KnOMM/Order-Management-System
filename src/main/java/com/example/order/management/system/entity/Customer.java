package com.example.order.management.system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true) // forces the constructor to initialize all fields with their default values
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
// Hibernate proxies are used for lazy loading and can sometimes cause issues during serialization.
// exclude Hibernate-specific properties from serialization
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(unique = true)
    private String registrationCode;
    @NonNull
    private String fullName;
    @NonNull
    private String email;
    @NonNull
    private String telephone;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<PurchaseOrder> purchaseOrders;
}
