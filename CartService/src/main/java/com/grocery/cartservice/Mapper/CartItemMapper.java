package com.grocery.cartservice.Mapper;

import com.grocery.cartservice.Dto.CartItemRequest;
import com.grocery.cartservice.Dto.CartItemResponse;
import com.grocery.cartservice.Model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CartItemMapper {

    // Convert DTO → Entity
    CartItem mapToCartItem(CartItemRequest cartItemRequest);

    // Update existing entity with new values
    void mapToCartItemEntity(CartItemRequest cartItemRequest, @MappingTarget CartItem cartItem);

    // Convert Entity → Response DTO
    @Mapping(source = "cart.id", target = "cartId")
    CartItemResponse mapToCartItemResponse(CartItem cartItem);

    // Convert List<Entity> → List<Response DTO>
    List<CartItemResponse> mapToCartItemResponse(List<CartItem> cartItems);
}
