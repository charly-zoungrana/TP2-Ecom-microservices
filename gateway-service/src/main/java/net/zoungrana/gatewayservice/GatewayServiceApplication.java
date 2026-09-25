package net.zoungrana.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	//@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		return builder.routes()
				.route("r1",predicates ->predicates.path("/customers/**").uri("lb://CUSTOMER-SERVICE") )
				.route("r2",predicates ->predicates.path("/products/**").uri("lb://INVENTORY-SERVICE") )
				.build();
	};


}
