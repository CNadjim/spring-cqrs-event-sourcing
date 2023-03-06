package com.nadjim.cqrs.core;

import com.nadjim.cqrs.core.configuration.GlobalExceptionHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Import({
        GlobalExceptionHandler.class
})
public @interface EnableGlobalExceptionHandler {
}
