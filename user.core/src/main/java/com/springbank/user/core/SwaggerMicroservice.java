package com.springbank.user.core;

import com.springbank.user.core.configuration.RouterController;
import com.springbank.user.core.configuration.SwaggerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Import({
        SwaggerConfiguration.class,
        RouterController.class
})
public @interface SwaggerMicroservice {
}
