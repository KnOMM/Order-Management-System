package com.example.order.management.system.service;

import com.example.order.management.system.entity.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class InitializationService {
    private final CustomerService customerService;
    private final OrderService orderService;
    private final ProductService productService;
    private final OrderLineService orderLineService;

    @PostConstruct
    private void initAppData() {
        /** Create products */
        var product1 = new Product("laptop-1", "lap/asu/bla/17", 100000);
        var product2 = new Product("tablet-1", "tab/len/bla/10", 10000);
        var product3 = new Product("tablet-2", "tab/sam/gre/12", 30000);
        var product4 = new Product("monitor-1", "mon/len/bla/20", 15000);
        var product5 = new Product("monitor-2", "mon/asu/whi/22", 20000);
        var product6 = new Product("laptop-2", "lap/len/blu/16", 110000);
        var copy = new Product("laptop-2", "lap/len/blu/16", 110000);
        var update = new Product("laptop-2", "lap/asu/red/17", 150000);

//        save
        productService.saveProduct(product1);
        productService.saveProduct(product2);
        productService.saveProduct(product3);
        productService.saveProduct(product4);
        productService.saveProduct(product5);
        productService.saveProduct(product6);
//        delete
        productService.saveProduct(copy);
        productService.deleteProduct(7);
//        update
        productService.updateProduct(update, 6);


        /** Initial configuration */
        // create customers
        Customer customer1 = new Customer("code", "Nazar Zhuhan", "test@test.com", "+1111111");
        customerService.saveCustomer(customer1);
        Customer customer2 = new Customer("unique", "John Doe", "john@doe.com", "+2222222");
        customerService.saveCustomer(customer2);
        Customer customer3 = new Customer("unique2", "Tester", "test@test.com", "+3333333");
        customerService.saveCustomer(customer3);

        // create orders
        PurchaseOrder order1ForCustomer1 = new PurchaseOrder(customer1, "02-01-2023");
        orderService.saveOrder(order1ForCustomer1);
        PurchaseOrder order2ForCustomer1 = new PurchaseOrder(customer1, "03-01-2023");
        orderService.saveOrder(order2ForCustomer1);
        PurchaseOrder order1ForCustomer2 = new PurchaseOrder(customer2, new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()));
        orderService.saveOrder(order1ForCustomer2);
        PurchaseOrder order3ForCustomer1 = new PurchaseOrder(customer2, new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()));
        orderService.saveOrder(order3ForCustomer1);
        PurchaseOrder order1ForCustomer3 = new PurchaseOrder(customer3, new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()));
        orderService.saveOrder(order1ForCustomer3);

        // save orders
        OrderLine orderLine1 = new OrderLine(product1, order1ForCustomer1, 1);
        OrderLine orderLine2 = new OrderLine(product5, order1ForCustomer1, 2);
        OrderLine orderLine3 = new OrderLine(product3, order1ForCustomer1, 1);
        OrderLine orderLine4 = new OrderLine(product3, order1ForCustomer2, 1);
        OrderLine orderLine5 = new OrderLine(product4, order2ForCustomer1, 3);
        OrderLine orderLine6 = new OrderLine(product6, order3ForCustomer1, 4);
        OrderLine orderLine7 = new OrderLine(product2, order2ForCustomer1, 2);
        OrderLine orderLine8 = new OrderLine(product1, order3ForCustomer1, 1);
        OrderLine orderLine10 = new OrderLine(product1, order1ForCustomer3, 10);
        orderLineService.saveOrderLine(orderLine1);
        orderLineService.saveOrderLine(orderLine2);
        orderLineService.saveOrderLine(orderLine3);
        orderLineService.saveOrderLine(orderLine4);
        orderLineService.saveOrderLine(orderLine5);
        orderLineService.saveOrderLine(orderLine6);
        orderLineService.saveOrderLine(orderLine7);
        orderLineService.saveOrderLine(orderLine8);
        orderLineService.saveOrderLine(orderLine10);

        // update orderLine
        OrderLine orderLine9 = new OrderLine(product3, order1ForCustomer1, 2);
        orderLineService.updateOrderLine(orderLine9, 1);
    }
}
