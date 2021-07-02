package com.example;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@OpenAPIDefinition(
        info = @Info(
                title = "stock app",
                version = "0.0",
                description = "My API",
                license = @License(name = "MIT")
        )
)
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        final ApplicationContext context = Micronaut.run(Application.class);
        final HelloWorldService service = context.getBean(HelloWorldService.class);
//        context.close();
//        Micronaut.run(Application.class, args);
    }
}
