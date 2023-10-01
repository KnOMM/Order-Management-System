package com.example.order.management.system.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String skuCode;
    @NonNull
    private Integer unitPrice; // represented in cents
}
