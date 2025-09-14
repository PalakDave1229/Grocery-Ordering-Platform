package com.grocery.cartservice.Controller;

import com.grocery.cartservice.Dto.CartRequest;
import com.grocery.cartservice.Dto.CartResponse;
import com.grocery.cartservice.Dto.CommonParam;
import com.grocery.cartservice.Service.CartService;
import com.grocery.cartservice.Utility.ResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    // Create Cart
    @PostMapping("/add")
    public ResponseEntity<?> createCart(@RequestBody CartRequest cartRequest) {
        CartResponse cartResponse = cartService.createCart(cartRequest);
        return ResponseBuilder.success(HttpStatus.CREATED, "Cart created successfully", cartResponse);
    }

    // Update Cart
    @PutMapping("/update")
    public ResponseEntity<?> updateCart(@RequestBody CartRequest request) {
        CartResponse cartResponse = cartService.updateCart(request);
        return ResponseBuilder.success(HttpStatus.OK, "Cart updated successfully", cartResponse);
    }

    // Get all Carts
    @GetMapping("/all")
    public ResponseEntity<?> getAllCarts() {
        List<CartResponse> cartResponses = cartService.getAllCarts();
        return ResponseBuilder.success(HttpStatus.OK, "Carts fetched successfully", cartResponses);
    }

    // Get Cart by ID
    @PostMapping("/by-id")
    public ResponseEntity<?> getCartById(@RequestBody CommonParam param) {
        CartResponse cartResponse = cartService.getCartById(param);
        return ResponseBuilder.success(HttpStatus.OK, "Cart fetched successfully", cartResponse);
    }

    // Delete Cart
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCart(@RequestBody CommonParam param) {
        cartService.deleteCart(param);
        return ResponseBuilder.success(HttpStatus.OK, "Cart deleted successfully", null);
    }

    // Clear Cart
    @PostMapping("/clear")
    public ResponseEntity<?> clearCart(@RequestBody CommonParam param) {
        cartService.clearCart(param);
        return ResponseBuilder.success(HttpStatus.OK, "Cart cleared successfully", null);
    }
}
