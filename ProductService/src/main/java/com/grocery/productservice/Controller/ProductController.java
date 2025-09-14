package com.grocery.productservice.Controller;

import com.grocery.productservice.Dto.CommonParam;
import com.grocery.productservice.Dto.PriceRangeParam;
import com.grocery.productservice.Dto.ProductRequest;
import com.grocery.productservice.Dto.ProductResponse;
import com.grocery.productservice.Service.ProductService;
import com.grocery.productservice.Utility.ResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    // Create product
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.createProduct(productRequest);
        return ResponseBuilder.success(HttpStatus.CREATED, "Product added successfully", productResponse);
    }

    // Update product
    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody ProductRequest request) {
        ProductResponse productResponse = productService.updateProduct(request);
        return ResponseBuilder.success(HttpStatus.OK, "Product updated successfully", productResponse);
    }

    // Get all products
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        List<ProductResponse> productResponses = productService.getAllProducts();
        return ResponseBuilder.success(HttpStatus.OK, "Products fetched successfully", productResponses);
    }

    // Get product by ID
    @PostMapping("/by-id")
    public ResponseEntity<?> getProductById(@RequestBody CommonParam param) {
        ProductResponse productResponse = productService.getProductById(param);
        return ResponseBuilder.success(HttpStatus.OK, "Product fetched successfully", productResponse);
    }

    // Delete product
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestBody CommonParam param) {
        productService.deleteProduct(param);
        return ResponseBuilder.success(HttpStatus.OK, "Product deleted successfully", null);
    }

    // Search products by name
    @PostMapping("/search")
    public ResponseEntity<?> searchProductsByName(@RequestBody CommonParam param) {
        List<ProductResponse> productResponses = productService.searchProductsByName(param);
        return ResponseBuilder.success(HttpStatus.OK, "Products fetched successfully", productResponses);
    }

    // Filter products by price range
    @PostMapping("/filter")
    public ResponseEntity<?> filterProductsByPriceRange(@RequestBody PriceRangeParam param) {
        List<ProductResponse> productResponses = productService.filterProductsByPriceRange(param);
        return ResponseBuilder.success(HttpStatus.OK, "Products fetched successfully", productResponses);
    }
}
