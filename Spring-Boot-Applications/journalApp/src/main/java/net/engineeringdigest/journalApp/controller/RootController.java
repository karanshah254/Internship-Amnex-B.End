package net.engineeringdigest.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

// for localhost:8090/ this will return the below message
@RestController
@Tag(name = "Root APIs", description = "APIs for Root")
public class RootController {
    @GetMapping("/")
    public String demo() {
        return "<h1>this is home page</h1>";
    }
}
