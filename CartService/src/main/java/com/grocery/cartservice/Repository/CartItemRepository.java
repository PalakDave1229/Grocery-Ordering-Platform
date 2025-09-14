package com.grocery.cartservice.Repository;

import com.grocery.cartservice.Model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    // Fetch all items for a specific cart
    List<CartItem> findByCartId(Long cartId);
}
