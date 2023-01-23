package com.miniProject.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Configuration
public class AppConfig {

    @Bean
    public RouteLocator getRoute(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p
                        .path("/auth/**")
                        .uri("lb://authApp/*"))
                .route(p->p
                        .path("/userApp/**")
                        .uri("lb://userApp/*"))
                .route(p->p
                        .path("/photodb/**")
                        .uri("lb://photoDatabase/*"))
                .build();
    }
}
