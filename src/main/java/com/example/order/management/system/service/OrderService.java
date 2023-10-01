package com.example.order.management.system.service;

import com.example.order.management.system.entity.PurchaseOrder;
import com.example.order.management.system.exception.ResourceNotFoundException;
import com.example.order.management.system.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<PurchaseOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public PurchaseOrder getOrderById(long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order", id, "id"));
    }

    public List<PurchaseOrder> getOrderByDate(String date) {
        return orderRepository.findAllBySubmissionDateOrderBySubmissionDate(date);
    }


    public List<PurchaseOrder> getOrderByProduct(String product) {
        return orderRepository.findOrderByProduct(product);
    }

    public List<PurchaseOrder> getOrderByCustomer(String name) {
        return orderRepository.findOrderByCustomer(name);
    }

    public PurchaseOrder saveOrder(PurchaseOrder purchaseOrder) {
        return orderRepository.save(purchaseOrder);
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
