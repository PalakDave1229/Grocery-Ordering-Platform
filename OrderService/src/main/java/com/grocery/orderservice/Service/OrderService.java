package com.grocery.orderservice.Service;



import com.grocery.orderservice.Dto.CommonParam;
import com.grocery.orderservice.Dto.OrderRequest;
import com.grocery.orderservice.Dto.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);

    OrderResponse updateOrder(OrderRequest request);

    OrderResponse getOrderById(CommonParam param);

    List<OrderResponse> getAllOrders();

    void deleteOrder(CommonParam param);
}