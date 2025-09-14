package com.grocery.cartservice.Service.Impl;

import com.grocery.cartservice.Dto.CartItemRequest;
import com.grocery.cartservice.Dto.CartItemResponse;
import com.grocery.cartservice.Dto.CommonParam;
import com.grocery.cartservice.Exception.CartItemNotFoundException;
import com.grocery.cartservice.Mapper.CartItemMapper;
import com.grocery.cartservice.Model.Cart;
import com.grocery.cartservice.Model.CartItem;
import com.grocery.cartservice.Repository.CartItemRepository;
import com.grocery.cartservice.Repository.CartRepository;
import com.grocery.cartservice.Service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final CartItemMapper cartItemMapper;

    @Override
    public List<CartItemResponse> getCartItemsByCartId(CommonParam param) {
        List<CartItem> items = cartItemRepository.findByCartId(param.getId());
        return items.stream()
                .map(cartItemMapper::mapToCartItemResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CartItemResponse getCartItemById(CommonParam param) {
        CartItem item = cartItemRepository.findById(param.getId())
                .orElseThrow(() -> new CartItemNotFoundException("CartItem not found with id: " + param.getId()));
        return cartItemMapper.mapToCartItemResponse(item);
    }

    @Override
    public CartItemResponse addCartItem(CartItemRequest request) {
        Cart cart = cartRepository.findById(request.getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + request.getCartId()));

        CartItem item = cartItemMapper.mapToCartItem(request);
        item.setCart(cart);
        cartItemRepository.save(item);
        return cartItemMapper.mapToCartItemResponse(item);
    }

    @Override
    public CartItemResponse updateCartItem(CartItemRequest request) {
        CartItem item = cartItemRepository.findById(request.getId())
                .orElseThrow(() -> new CartItemNotFoundException("CartItem not found with id: " + request.getId()));

        cartItemMapper.mapToCartItemEntity(request, item);
        cartItemRepository.save(item);
        return cartItemMapper.mapToCartItemResponse(item);
    }

    @Override
    public void deleteCartItem(CommonParam param) {
        CartItem item = cartItemRepository.findById(param.getId())
                .orElseThrow(() -> new CartItemNotFoundException("CartItem not found with id: " + param.getId()));
        cartItemRepository.delete(item);
    }
}