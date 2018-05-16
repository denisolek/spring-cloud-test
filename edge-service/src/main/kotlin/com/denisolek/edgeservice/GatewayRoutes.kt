package com.denisolek.edgeservice

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GatewayRoutes {
    @Bean
    fun routesDefinition(routeLocatorBuilder: RouteLocatorBuilder): RouteLocator =
        routeLocatorBuilder.routes {
            route {
                path("/physio/**")
                uri("lb://health-service")
            }
            route {
                path("/patient/**")
                uri("lb://health-service")
            }
            route {
                path("/authorization/**")
                uri("lb://authorization-service")
            }
        }
}