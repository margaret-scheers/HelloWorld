package com.in28minutes.rest.webservices.restfulwebservices.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping (path="/helloworld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping (path="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping (path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World %s", name));
    }

    @GetMapping (path="/helloworld-internationalized")
    public String helloWorldInternationalized() {
        return messageSource.getMessage("good.morning.message",
                null, LocaleContextHolder.getLocale());
    }
}
