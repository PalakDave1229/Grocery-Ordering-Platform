package com.grocery.productservice.Service;

import com.grocery.productservice.Dto.CommonParam;
import com.grocery.productservice.Dto.PriceRangeParam;
import com.grocery.productservice.Dto.ProductRequest;
import com.grocery.productservice.Dto.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    ProductResponse updateProduct(ProductRequest request);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(CommonParam param);

    void deleteProduct(CommonParam param);

    List<ProductResponse> searchProductsByName(CommonParam param);

    List<ProductResponse> filterProductsByPriceRange(PriceRangeParam param);
}
