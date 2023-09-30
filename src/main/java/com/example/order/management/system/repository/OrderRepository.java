package com.example.order.management.system.repository;

import com.example.order.management.system.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<PurchaseOrder, Long> {
}
