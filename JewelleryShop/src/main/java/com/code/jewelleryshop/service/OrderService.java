package com.code.jewelleryshop.service;

import com.code.jewelleryshop.entity.Order;
import com.code.jewelleryshop.repo.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders()
    {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Integer orderId)
    {
        return orderRepository.findById(orderId);
    }

    public Order createOrder(Order order) {
        order.setPaymentMode("Cash on Delivery");
        return orderRepository.save(order);
    }

    public Order updateOrder(Integer orderId, Order incomingOrder) {
        Optional<Order> existingOrder = orderRepository.findById(orderId);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            order.setName(incomingOrder.getName());
            order.setQuantity(incomingOrder.getQuantity());
            order.setPaymentMode(incomingOrder.getPaymentMode());
            return orderRepository.save(order);
        } else {
            throw new EntityNotFoundException("Order not found with id " + orderId);
        }
    }

    public String deleteOrderById(Integer orderId) {
        try {
            orderRepository.deleteById(orderId);
            return "Order deleted successfully";
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException("Order not found with id " + orderId);
        }
    }
}
