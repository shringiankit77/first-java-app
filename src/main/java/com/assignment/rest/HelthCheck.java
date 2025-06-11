package com.assignment.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelthCheck {
    @GetMapping("/health")
    public ResponseEntity getHealth(){
        return ResponseEntity.ok("{\"status\":\"UP\"}");
    }
}
