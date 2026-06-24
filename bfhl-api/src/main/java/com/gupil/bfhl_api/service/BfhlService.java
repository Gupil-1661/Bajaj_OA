package com.gupil.bfhl_api.service;

import com.gupil.bfhl_api.dto.BfhlRequest;
import com.gupil.bfhl_api.dto.BfhlResponse;

public interface BfhlService {
    BfhlResponse processData(BfhlRequest request);
}
