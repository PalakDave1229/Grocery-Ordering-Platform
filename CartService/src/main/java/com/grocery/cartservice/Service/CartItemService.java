package com.grocery.cartservice.Service;

import com.grocery.cartservice.Dto.CartItemRequest;
import com.grocery.cartservice.Dto.CartItemResponse;
import com.grocery.cartservice.Dto.CommonParam;

import java.util.List;

public interface CartItemService {

    // Fetch all items for a specific cart
    List<CartItemResponse> getCartItemsByCartId(CommonParam param);

    // Fetch a single cart item by ID
    CartItemResponse getCartItemById(CommonParam param);

    // Add a new item to the cart
    CartItemResponse addCartItem(CartItemRequest request);

    // Update an existing cart item
    CartItemResponse updateCartItem(CartItemRequest request);

    // Delete a cart item
    void deleteCartItem(CommonParam param);
}
