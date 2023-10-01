package com.example.order.management.system.service;

import com.example.order.management.system.entity.OrderLine;
import com.example.order.management.system.entity.PurchaseOrder;
import com.example.order.management.system.exception.ResourceNotFoundException;
import com.example.order.management.system.repository.OrderLineRepository;
import com.example.order.management.system.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final OrderRepository orderRepository;

    public List<OrderLine> getOrderLinesByOrder(long id) {
        PurchaseOrder existingOrder = orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order", id, "id"));
        return orderLineRepository.findOrderLinesWithProductsByOrder(existingOrder);
    }

    public OrderLine saveOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    public void deleteOrderLine(long id) {
        orderLineRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("OrderLine", id, "id"));
        orderLineRepository.deleteById(id);
    }

    public OrderLine updateOrderLine(OrderLine orderLine, long id) {
        OrderLine existingOrderLine = orderLineRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("OrderLine", id, "id"));
        existingOrderLine.setPurchaseOrder(orderLine.getPurchaseOrder());
        existingOrderLine.setProduct(orderLine.getProduct());
        existingOrderLine.setQuantity(orderLine.getQuantity());
        orderLineRepository.save(existingOrderLine);
        return existingOrderLine;
    }
}
