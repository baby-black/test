package com.example.test.services;

import com.example.test.models.Order;
import com.example.test.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository; // Sửa tên biến cho đúng

    public List<Order> findAll() {
        return ordersRepository.findAll();
    }

    public Order findById(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found")); // Sửa thông báo lỗi
    }

    public Order save(Order order) {
        return ordersRepository.save(order); // Sửa tham số truyền vào
    }

    public Order update(Long id, Order order) {
        // Kiểm tra xem đơn hàng có tồn tại không trước khi cập nhật
        if (!ordersRepository.existsById(id)) { // Sửa tên biến
            throw new RuntimeException("Order not found");
        }
        order.setId(id); // Giả định rằng bạn có phương thức setId trong Order
        return ordersRepository.save(order);
    }

    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }
}