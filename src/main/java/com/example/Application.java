package com.example;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        final ApplicationContext context = Micronaut.run(Application.class);
        final HelloWorldService service = context.getBean(HelloWorldService.class);
        context.close();
//        Micronaut.run(Application.class, args);
    }
}
