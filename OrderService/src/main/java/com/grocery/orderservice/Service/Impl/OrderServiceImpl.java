package com.grocery.orderservice.Service.Impl;


import com.grocery.orderservice.Dto.CommonParam;
import com.grocery.orderservice.Dto.OrderRequest;
import com.grocery.orderservice.Dto.OrderResponse;
import com.grocery.orderservice.Exception.OrderNotFoundException;
import com.grocery.orderservice.Mapper.OrderMapper;
import com.grocery.orderservice.Model.Order;
import com.grocery.orderservice.Repository.OrderRepository;
import com.grocery.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        // Map request → entity
        Order order = orderMapper.mapToOrder(request);
        // Set parent reference for nested items
        if (order.getItems() != null) {
            order.getItems().forEach(item -> item.setOrder(order));
        }
        // Calculate total price
        int totalPrice = order.getItems().stream()
                .mapToInt(item -> item.getPrice() * item.getQuantity())
                .sum();
        order.setTotalPrice(totalPrice);
        // Set default status
        if (order.getStatus() == null) {
            order.setStatus("PENDING");
        }
        // Save order (cascade will save items)
        Order savedOrder = orderRepository.save(order);
        // Map saved entity → response
        return orderMapper.mapToOrderResponse(savedOrder);
    }

    @Override
    public OrderResponse updateOrder(OrderRequest request) {
        Order order = orderRepository.findById(request.getId())
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + request.getId()));

        // Map fields from DTO to entity (userId, items, etc.)
        orderMapper.mapToOrderEntity(request, order);

        // Set parent for items
        if (order.getItems() != null) {
            order.getItems().forEach(item -> item.setOrder(order));
        }

        // Recalculate total price
        int totalPrice = order.getItems().stream()
                .mapToInt(item -> item.getPrice() * item.getQuantity())
                .sum();
        order.setTotalPrice(totalPrice);

        // Set default status if null
        if (order.getStatus() == null) {
            order.setStatus("PENDING");
        }

        // Save updated order
        Order updatedOrder = orderRepository.save(order);

        return orderMapper.mapToOrderResponse(updatedOrder);
    }

    @Override
    public OrderResponse getOrderById(CommonParam param) {
        Order order = orderRepository.findById(param.getId())
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + param.getId()));
        return orderMapper.mapToOrderResponse(order);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.mapToOrderResponse(orders);
    }

    @Override
    public void deleteOrder(CommonParam param) {
        Order order = orderRepository.findById(param.getId())
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + param.getId()));
        orderRepository.delete(order);
    }
}
