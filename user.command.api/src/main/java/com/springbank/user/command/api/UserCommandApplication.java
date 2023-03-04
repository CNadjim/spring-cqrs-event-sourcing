package com.springbank.user.command.api;

import com.springbank.user.core.AxonMicroservice;
import com.springbank.user.core.MongoMicroservice;
import com.springbank.user.core.SwaggerMicroservice;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MongoMicroservice
@AxonMicroservice
@SwaggerMicroservice
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "User command API", version = "1.0", description = "Documentation user command API v1.0"))
public class UserCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCommandApplication.class, args);
    }


}
