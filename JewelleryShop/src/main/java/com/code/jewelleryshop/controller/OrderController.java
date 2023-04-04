package com.code.jewelleryshop.controller;

import com.code.jewelleryshop.entity.Order;
import com.code.jewelleryshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders()
    {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable("id") Integer orderId)
    {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order)
    {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable("id") Integer orderId, @RequestBody Order incomingOrder)
    {
        return orderService.updateOrder(orderId, incomingOrder);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderById(@PathVariable("id") Integer orderId)
    {
        return orderService.deleteOrderById(orderId);
    }
}
