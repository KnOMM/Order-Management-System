package com.example.order.management.system.controller;

import com.example.order.management.system.entity.OrderLine;
import com.example.order.management.system.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order_line")
@RequiredArgsConstructor
public class OrderLineController {
    private final OrderLineService orderLineService;

    @PostMapping
    public OrderLine saveOrderLine(@RequestBody OrderLine orderLine) {
        return orderLineService.saveOrderLine(orderLine);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderLine(@PathVariable long id) {
        orderLineService.deleteOrderLine(id);
        return "Deleted successfully!!!";
    }

    @PutMapping("/{id}")
    public OrderLine updateOrderLine(@RequestParam OrderLine orderLine, @PathVariable long id) {
        return orderLineService.updateOrderLine(orderLine, id);
    }
}
