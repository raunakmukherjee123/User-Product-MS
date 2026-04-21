package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
                .route("PracticeMicroservice",r->r.path("/api/user/**")
                        .uri("lb://PracticeMicroservice"))
                .route("PracticeMicroservice1",r->r.path("/api/product/**")
                        .filters(f->f.circuitBreaker(config ->
                                config.setName("appBreaker")))
                        .uri("lb://PracticeMicroservice1"))
                .build();
    }
}
