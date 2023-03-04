package com.springbank.user.core;


import com.springbank.user.core.configuration.MongoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Import({
        MongoConfiguration.class
})
public @interface MongoMicroservice {
}
