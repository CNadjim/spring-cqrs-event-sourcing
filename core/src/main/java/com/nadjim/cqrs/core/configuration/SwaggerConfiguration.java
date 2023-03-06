package com.nadjim.cqrs.core.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

import static org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type.REACTIVE;
import static org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type.SERVLET;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI(){
        return  new OpenAPI();
    }

    @Controller
    @ConditionalOnWebApplication(type = REACTIVE)
    public static class ReactiveSwaggerRouter {
        @GetMapping
        public Mono<Void> swagger(final ServerHttpResponse response) {
            response.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
            response.getHeaders().setLocation(URI.create("/swagger-ui.html"));
            return response.setComplete();
        }
    }


    @Controller
    @ConditionalOnWebApplication(type = SERVLET)
    public static class MvcSwaggerRouter {
        @GetMapping
        public void swagger(final HttpServletResponse response) throws IOException {
            response.sendRedirect("/swagger-ui.html");
        }

    }
}
