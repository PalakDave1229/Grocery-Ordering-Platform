package com.grocery.gateway_service.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange -> exchange
                        // Actuator endpoints are public
                        .pathMatchers("/actuator/**").permitAll()

                        // Product browsing (public access allowed)
                        .pathMatchers("/products/**").permitAll()

                        // Only logged-in users (CONSUMER or ADMIN) can use cart & orders
                        .pathMatchers("/cart/**", "/orders/**").hasAnyRole("CONSUMER", "ADMIN")

                        // Only ADMIN can add/update/delete products
                        .pathMatchers("/products/admin/**").hasRole("ADMIN")

                        // Only ADMIN can update order status
                        .pathMatchers("/orders/admin/**").hasRole("ADMIN")

                        // Default: everything else needs authentication
                        .anyExchange().authenticated()
                )
                .build();
    }
}
