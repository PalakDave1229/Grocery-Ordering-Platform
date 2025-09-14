package com.grocery.productservice.Service.Impl;

import com.grocery.productservice.Dto.CommonParam;
import com.grocery.productservice.Dto.PriceRangeParam;
import com.grocery.productservice.Dto.ProductRequest;
import com.grocery.productservice.Dto.ProductResponse;
import com.grocery.productservice.Exception.ProductNotFoundException;
import com.grocery.productservice.Mapper.ProductMapper;
import com.grocery.productservice.Model.Product;
import com.grocery.productservice.Repository.ProductRepository;
import com.grocery.productservice.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product product = productMapper.mapToProduct(request);
        productRepository.save(product);
        return productMapper.mapToProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(ProductRequest request) {
        Product product = productRepository.findById(request.getId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found with Id: " + request.getId()));

        productMapper.mapToProductEntity(request, product);
        productRepository.save(product);

        return productMapper.mapToProductResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.mapToProductResponse(products);
    }

    @Override
    public ProductResponse getProductById(CommonParam param) {
        Product product = productRepository.findById(param.getId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found with Id: " + param.getId()));
        return productMapper.mapToProductResponse(product);
    }

    @Override
    public void deleteProduct(CommonParam param) {
        Product product = productRepository.findById(param.getId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found with Id: " + param.getId()));
        productRepository.delete(product);
    }

    @Override
    public List<ProductResponse> searchProductsByName(CommonParam param) {
        List<Product> products = productRepository.findByName(param.getName());

        if (products == null || products.isEmpty()) {
            throw new ProductNotFoundException("No product found with name: " + param.getName());
        }

        return productMapper.mapToProductResponse(products);
    }

    @Override
    public List<ProductResponse> filterProductsByPriceRange(PriceRangeParam param) {
        List<Product> products = productRepository.findByPriceBetween(param.getMinPrice(), param.getMaxPrice());
        return productMapper.mapToProductResponse(products);
    }
}
