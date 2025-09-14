package com.grocery.orderservice.Repository;


import com.grocery.orderservice.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // No custom methods unless required by the doc
}
