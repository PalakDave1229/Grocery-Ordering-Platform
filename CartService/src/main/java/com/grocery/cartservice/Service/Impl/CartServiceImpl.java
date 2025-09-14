package com.grocery.cartservice.Service.Impl;

import com.grocery.cartservice.Dto.CartRequest;
import com.grocery.cartservice.Dto.CartResponse;
import com.grocery.cartservice.Dto.CommonParam;
import com.grocery.cartservice.Exception.CartNotFoundException;
import com.grocery.cartservice.Mapper.CartMapper;
import com.grocery.cartservice.Model.Cart;
import com.grocery.cartservice.Repository.CartRepository;
import com.grocery.cartservice.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Override
    public CartResponse createCart(CartRequest request) {
        Cart cart = cartMapper.mapToCart(request);
        Cart savedCart = cartRepository.save(cart);
        return cartMapper.mapToCartResponse(savedCart);
    }

    // Update Cart
    @Override
    public CartResponse updateCart(CartRequest request) {
        Cart cart = cartRepository.findById(request.getId())
                .orElseThrow(() -> new CartNotFoundException("Cart not found with id: " + request.getId()));

        cartMapper.mapToCartEntity(request, cart); // update fields
        Cart updatedCart = cartRepository.save(cart);
        return cartMapper.mapToCartResponse(updatedCart);
    }

    @Override
    public CartResponse getCartById(CommonParam param) {
        Cart cart = cartRepository.findById(param.getId())
                .orElseThrow(() -> new CartNotFoundException("Cart not found with id: " + param.getId()));
        return cartMapper.mapToCartResponse(cart);
    }

    @Override
    public List<CartResponse> getAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        return cartMapper.mapToCartResponse(carts);
    }

    @Override
    public void deleteCart(CommonParam param) {
        Cart cart = cartRepository.findById(param.getId())
                .orElseThrow(() -> new CartNotFoundException("Cart not found with id: " + param.getId()));
        cartRepository.delete(cart);
    }

    @Override
    public void clearCart(CommonParam param) {
        Cart cart = cartRepository.findById(param.getId())
                .orElseThrow(() -> new CartNotFoundException("Cart not found with id: " + param.getId()));
        cart.setTotalPrice(0);
        cartRepository.save(cart);
    }
}