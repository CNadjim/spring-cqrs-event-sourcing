package com.nadjim.cqrs.core.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type.REACTIVE;
import static org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type.SERVLET;

@Configuration
public class CorsConfiguration {

    @ConditionalOnWebApplication(type = REACTIVE)
    public static class ReactiveCorsConfiguration implements WebFluxConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry corsRegistry) {
            corsRegistry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "DELETE", "PATCH", "PUT")
                    .maxAge(3600);
        }
    }

    @ConditionalOnWebApplication(type = SERVLET)
    public static class WebMvcCorsConfiguration implements WebMvcConfigurer{
        @Override
        public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry corsRegistry) {
            corsRegistry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "DELETE", "PATCH", "PUT")
                    .maxAge(3600);
        }
    }
}
