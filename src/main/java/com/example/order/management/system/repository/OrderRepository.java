package com.example.order.management.system.repository;

import com.example.order.management.system.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<PurchaseOrder, Long> {
    List<PurchaseOrder> findAllBySubmissionDateOrderBySubmissionDate(String date);

    @Query("SELECT po FROM OrderLine ol JOIN ol.purchaseOrder po WHERE ol.product.name = :product")
        // search orders by product
    List<PurchaseOrder> findOrderByProduct(@Param("product") String product);

    @Query("SELECT po FROM OrderLine ol JOIN ol.purchaseOrder po WHERE ol.purchaseOrder.customer.fullName = :name")
        // search by customer name
    List<PurchaseOrder> findOrderByCustomer(@Param("name") String customer);
}
