package com.testproject.uaaserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class UaaController {

    private final RestTemplate restTemplate;

    public UaaController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/token")
    public ResponseEntity<String> getToken() {
        String apiKeyAuthProviderUrl = "http://localhost:8081/api/token";
        ResponseEntity<String> response = restTemplate.getForEntity(apiKeyAuthProviderUrl, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
