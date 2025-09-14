package com.grocery.cartservice.Controller;

import com.grocery.cartservice.Dto.CartItemRequest;
import com.grocery.cartservice.Dto.CartItemResponse;
import com.grocery.cartservice.Dto.CommonParam;
import com.grocery.cartservice.Service.CartItemService;
import com.grocery.cartservice.Utility.ResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartItemController {

    private final CartItemService cartItemService;

    // Add Cart Item
    @PostMapping("/cart-items/add")
    public ResponseEntity<?> addCartItem(@RequestBody CartItemRequest request) {
        CartItemResponse response = cartItemService.addCartItem(request);
        return ResponseBuilder.success(HttpStatus.CREATED, "Cart item added successfully", response);
    }

    // Update Cart Item
    @PutMapping("/cart-items/update")
    public ResponseEntity<?> updateCartItem(@RequestBody CartItemRequest request) {
        CartItemResponse response = cartItemService.updateCartItem(request);
        return ResponseBuilder.success(HttpStatus.OK, "Cart item updated successfully", response);
    }

    // Get all Cart Items by Cart ID
    @PostMapping("/cart-items/all")
    public ResponseEntity<?> getCartItemsByCartId(@RequestBody CommonParam param) {
        List<CartItemResponse> responses = cartItemService.getCartItemsByCartId(param);
        return ResponseBuilder.success(HttpStatus.OK, "Cart items fetched successfully", responses);
    }

    // Get Cart Item by ID
    @PostMapping("/cart-items/by-id")
    public ResponseEntity<?> getCartItemById(@RequestBody CommonParam param) {
        CartItemResponse response = cartItemService.getCartItemById(param);
        return ResponseBuilder.success(HttpStatus.OK, "Cart item fetched successfully", response);
    }

    // Delete Cart Item
    @DeleteMapping("/cart-items/delete")
    public ResponseEntity<?> deleteCartItem(@RequestBody CommonParam param) {
        cartItemService.deleteCartItem(param);
        return ResponseBuilder.success(HttpStatus.OK, "Cart item deleted successfully", null);
    }
}