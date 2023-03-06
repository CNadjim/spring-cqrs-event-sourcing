package com.nadjim.cqrs.core;

import com.nadjim.cqrs.core.configuration.CorsConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Import({
        CorsConfiguration.class,
        CorsConfiguration.WebMvcCorsConfiguration.class,
        CorsConfiguration.ReactiveCorsConfiguration.class
})
public @interface EnableCors {
}
