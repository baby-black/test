package com.example.test.controllers;

import com.example.test.models.Order;
import com.example.test.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders") // Thay đổi thành chữ thường theo quy ước REST
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    // Get all orders
    @GetMapping
    public List<Order> getAllOrders() { // Đổi tên phương thức cho chính xác
        return ordersService.findAll(); // Sửa tên biến
    }

    // Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = ordersService.findById(id); // Sửa tên biến
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    // Create a new order
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = ordersService.save(order); // Sửa tham số truyền vào
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

    // Update an existing order
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) { // Đổi tên phương thức cho chính xác
        Order updatedOrder = ordersService.update(id, order); // Sửa tham số truyền vào
        return updatedOrder != null ? ResponseEntity.ok(updatedOrder) : ResponseEntity.notFound().build();
    }

    // Delete an order by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        ordersService.delete(id);
        return ResponseEntity.noContent().build();
    }
}