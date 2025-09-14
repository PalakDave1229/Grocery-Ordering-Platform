package com.grocery.cartservice.Service;

import com.grocery.cartservice.Dto.CartRequest;
import com.grocery.cartservice.Dto.CartResponse;
import com.grocery.cartservice.Dto.CommonParam;

import java.util.List;

public interface CartService {

    CartResponse createCart(CartRequest request);

    CartResponse updateCart(CartRequest request);

    CartResponse getCartById(CommonParam param);

    List<CartResponse> getAllCarts();

    void deleteCart(CommonParam param);

    void clearCart(CommonParam param);
}
