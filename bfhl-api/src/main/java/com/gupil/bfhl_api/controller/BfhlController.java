package com.gupil.bfhl_api.controller;

import com.gupil.bfhl_api.dto.BfhlRequest;
import com.gupil.bfhl_api.dto.BfhlResponse;
import com.gupil.bfhl_api.service.BfhlService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BfhlController {
    private final BfhlService bfhlService;

    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping("/bfhl")
    public BfhlResponse bfhl(@RequestBody BfhlRequest request) {
        return bfhlService.processData(request);
    }
}
