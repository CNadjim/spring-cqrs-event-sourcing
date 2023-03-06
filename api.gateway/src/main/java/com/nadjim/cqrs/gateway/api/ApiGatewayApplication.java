package com.nadjim.cqrs.gateway.api;

import com.nadjim.cqrs.core.EnableCors;
import com.nadjim.cqrs.core.SwaggerMicroservice;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCors
@SwaggerMicroservice
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "CQRS project API", version = "1.0", description = "Documentation API v1.0"))
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
