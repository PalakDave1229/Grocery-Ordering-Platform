package com.grocery.orderservice.Mapper;

import com.grocery.orderservice.Dto.OrderItemRequest;
import com.grocery.orderservice.Dto.OrderItemResponse;
import com.grocery.orderservice.Model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface OrderItemMapper {

    // Convert DTO → Entity
    OrderItem mapToOrderItem(OrderItemRequest orderItemRequest);

    // Update existing entity with new values
    void mapToOrderItemEntity(OrderItemRequest orderItemRequest, @MappingTarget OrderItem orderItem);

    // Convert Entity → Response DTO
    OrderItemResponse mapToOrderItemResponse(OrderItem orderItem);

    // Convert List<Entity> → List<Response DTO>
    List<OrderItemResponse> mapToOrderItemResponse(List<OrderItem> orderItems);
}
