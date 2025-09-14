package com.grocery.cartservice.Integration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductIntegrationService {

    private final RestTemplate restTemplate;

    private final String PRODUCT_SERVICE_URL = "http://localhost:8081/product";

    public ProductResponse getProductById(Long productId){
        CommonParam param = new CommonParam();
        param.setId(productId);

        ResponseEntity<ProductResponse> response = restTemplate.postForEntity(
                PRODUCT_SERVICE_URL + "/by-id", param, ProductResponse.class
        );

        return response.getBody();
    }
}
