package com.example.order.management.system.repository;

import com.example.order.management.system.entity.OrderLine;
import com.example.order.management.system.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    @Query("SELECT ol FROM OrderLine ol JOIN FETCH ol.product WHERE ol.purchaseOrder = :order")
    List<OrderLine> findOrderLinesWithProductsByOrder(@Param("order") PurchaseOrder order);
}
