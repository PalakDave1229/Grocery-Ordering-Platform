package com.grocery.orderservice.Controller;

import com.grocery.orderservice.Dto.CommonParam;
import com.grocery.orderservice.Dto.OrderRequest;
import com.grocery.orderservice.Dto.OrderResponse;
import com.grocery.orderservice.Service.OrderService;
import com.grocery.orderservice.Utility.ResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    // Create Order
    @PostMapping("/add")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.createOrder(orderRequest);
        return ResponseBuilder.success(HttpStatus.CREATED, "Order created successfully", orderResponse);
    }

    // Update Order
    @PutMapping("/update")
    public ResponseEntity<?> updateOrder(@RequestBody OrderRequest request) {
        OrderResponse orderResponse = orderService.updateOrder(request);
        return ResponseBuilder.success(HttpStatus.OK, "Order updated successfully", orderResponse);
    }

    // Get all Orders
    @GetMapping("/all")
    public ResponseEntity<?> getAllOrders() {
        List<OrderResponse> orderResponses = orderService.getAllOrders();
        return ResponseBuilder.success(HttpStatus.OK, "Orders fetched successfully", orderResponses);
    }

    // Get Order by ID
    @PostMapping("/by-id")
    public ResponseEntity<?> getOrderById(@RequestBody CommonParam param) {
        OrderResponse orderResponse = orderService.getOrderById(param);
        return ResponseBuilder.success(HttpStatus.OK, "Order fetched successfully", orderResponse);
    }

    // Delete Order
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteOrder(@RequestBody CommonParam param) {
        orderService.deleteOrder(param);
        return ResponseBuilder.success(HttpStatus.OK, "Order deleted successfully", null);
    }
}