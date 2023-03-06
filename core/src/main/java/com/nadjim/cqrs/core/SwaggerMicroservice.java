package com.nadjim.cqrs.core;

import com.nadjim.cqrs.core.configuration.SwaggerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Import({
        SwaggerConfiguration.class,
        SwaggerConfiguration.MvcSwaggerRouter.class,
        SwaggerConfiguration.ReactiveSwaggerRouter.class
})
public @interface SwaggerMicroservice {
}
