package com.springbank.user.query.api;

import com.nadjim.cqrs.core.AxonMicroservice;
import com.nadjim.cqrs.core.EnableCors;
import com.nadjim.cqrs.core.MongoMicroservice;
import com.nadjim.cqrs.core.SwaggerMicroservice;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCors
@AxonMicroservice
@MongoMicroservice
@SwaggerMicroservice
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "User query API", version = "1.0", description = "Documentation user query API v1.0"))
public class UserQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserQueryApplication.class, args);
    }

}
