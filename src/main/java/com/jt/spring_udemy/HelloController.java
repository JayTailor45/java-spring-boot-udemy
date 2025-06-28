package com.jt.spring_udemy;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloResponse sayHello() {
        return new HelloResponse("Hello Spring World!");
    }

    @PostMapping("/hello")
    public HelloResponse helloPost(@RequestBody String name) {
        return new HelloResponse("Hello " + name + "!");
    }

    @GetMapping("/hello/{name}")
    public HelloResponse helloPostWithPathParams(@PathVariable String name) {
        return new HelloResponse("Hello " + name + "!");
    }

}
