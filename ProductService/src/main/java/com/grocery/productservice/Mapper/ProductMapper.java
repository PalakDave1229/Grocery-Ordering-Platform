package com.grocery.productservice.Mapper;


import com.grocery.productservice.Dto.ProductRequest;
import com.grocery.productservice.Dto.ProductResponse;
import com.grocery.productservice.Model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ProductMapper {

    // Convert DTO → Entity
    Product mapToProduct(ProductRequest productRequest);

    // Update existing entity with new values
    void mapToProductEntity(ProductRequest productRequest, @MappingTarget Product product);

    // Convert Entity → Response DTO
    ProductResponse mapToProductResponse(Product product);

    // Convert List<Entity> → List<Response DTO>
    List<ProductResponse> mapToProductResponse(List<Product> products);
}

