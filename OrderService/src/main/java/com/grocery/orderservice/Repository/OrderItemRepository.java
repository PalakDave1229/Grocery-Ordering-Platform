package com.grocery.orderservice.Repository;

import com.grocery.orderservice.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // No custom methods unless required by the doc
}
