package com.grocery.productservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonParam {
    private Long id;     // for update, delete, or fetch by id
    private String name; // optional if you later support search by name
}