package com.example.order.management.system.controller;

import com.example.order.management.system.entity.OrderLine;
import com.example.order.management.system.entity.PurchaseOrder;
import com.example.order.management.system.service.OrderLineService;
import com.example.order.management.system.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderLineService orderLineService;

    @GetMapping
    public List<PurchaseOrder> getOrders(@RequestParam(value = "date", required = false) Optional<String> date,
                                         @RequestParam(value = "product", required = false) Optional<String> product,
                                         @RequestParam(value = "name", required = false) Optional<String> name) {
        {
            if (date.isPresent()) {
                return orderService.getOrderByDate(date.get());
            } else if (product.isPresent()) {
                return orderService.getOrderByProduct(product.get());
            } else if (name.isPresent()) {
                return orderService.getOrderByCustomer(name.get());
            }
            return orderService.getAllOrders();
        }
    }

    @GetMapping("/{id}")
    public List<OrderLine> getOrderById(@PathVariable long id) {
        return orderLineService.getOrderLinesByOrder(id);
    }

    @PostMapping
    public PurchaseOrder createOrder(@RequestBody PurchaseOrder order) {
        return orderService.saveOrder(order);
    }
}
