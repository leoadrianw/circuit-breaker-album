package com.cbv2.r4j.controller;

import com.cbv2.r4j.service.AlbumService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @Autowired
    private Environment environment;

    @GetMapping("/message")
    public String getMessage() {
        return environment.getProperty("welcome.message");
    }

    @GetMapping("/album")
    @CircuitBreaker(name = "albumcb", fallbackMethod = "fallback")
    public String album() {
        return albumService.getAlbumList();
    }

    public String fallback(Throwable throwable) {
        return "Test";
    }
}
