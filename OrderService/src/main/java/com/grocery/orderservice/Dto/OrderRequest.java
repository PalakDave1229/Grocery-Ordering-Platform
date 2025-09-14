package com.grocery.orderservice.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private Long id;            // only required for update
    private String userId;                  // Firebase user UID
    private List<OrderItemRequest> items;   // List of products in the order
}
