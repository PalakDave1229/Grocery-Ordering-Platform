package com.grocery.orderservice.Mapper;

import com.grocery.orderservice.Dto.OrderRequest;
import com.grocery.orderservice.Dto.OrderResponse;
import com.grocery.orderservice.Model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
@Component
public interface OrderMapper {

    // Convert DTO → Entity
    Order mapToOrder(OrderRequest orderRequest);

    // Update existing entity with new values
    void mapToOrderEntity(OrderRequest orderRequest, @MappingTarget Order order);

    // Convert Entity → Response DTO
    @Mapping(source = "id", target = "orderId") // map entity id → response orderId
    OrderResponse mapToOrderResponse(Order order);

    // Convert List<Entity> → List<Response DTO>
    List<OrderResponse> mapToOrderResponse(List<Order> orders);
}
