package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("${hello.controller.path}")
public class HelloWorldController {

    private HelloWorldService service;
    private final GreetingConfig config;

    public HelloWorldController(final HelloWorldService service, final GreetingConfig config) {
        this.service = service;
        this.config = config;
    }

    @Get("/")
    public String index() {
        return service.sayHi();
    }

    @Get("/en")
    public String greetingInEnglish() {
        return config.getEn();
    }

    @Get("/de")
    public String greetingInGerman() {
        return config.getDe();
    }
}
