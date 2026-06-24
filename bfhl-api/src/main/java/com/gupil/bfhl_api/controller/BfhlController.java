package com.gupil.bfhl_api.controller;

import com.gupil.bfhl_api.dto.BfhlRequest;
import com.gupil.bfhl_api.dto.BfhlResponse;
import com.gupil.bfhl_api.service.BfhlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BfhlController {
    private final BfhlService bfhlService;

    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/bfhl")
    public BfhlResponse bfhl(@RequestBody BfhlRequest request) {
        return bfhlService.processData(request);
    }
}
