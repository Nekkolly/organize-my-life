package com.organize.my.life.api;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/v1/healthcheck")
public class HealthCheckController {

    @GetMapping
    public Map<String, String> healthCheck() {
        return Map.of("status", "ok");
    }
}