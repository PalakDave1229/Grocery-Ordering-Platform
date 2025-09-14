package com.grocery.cartservice.Mapper;


import com.grocery.cartservice.Dto.CartRequest;
import com.grocery.cartservice.Dto.CartResponse;
import com.grocery.cartservice.Model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CartMapper {

    // Convert DTO → Entity
    Cart mapToCart(CartRequest cartRequest);

    // Update existing entity with new values
    void mapToCartEntity(CartRequest cartRequest, @MappingTarget Cart cart);

    // Convert Entity → Response DTO
    CartResponse mapToCartResponse(Cart cart);

    // Convert List<Entity> → List<Response DTO>
    List<CartResponse> mapToCartResponse(List<Cart> carts);
}
