package com.nadjim.cqrs.user.command.api;

import com.nadjim.cqrs.core.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCors
@MongoMicroservice
@AxonMicroservice
@SwaggerMicroservice
@SpringBootApplication
@EnableGlobalExceptionHandler
@OpenAPIDefinition(info = @Info(title = "User command API", version = "1.0", description = "Documentation user command API v1.0"))
public class UserCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCommandApplication.class, args);
    }


}
