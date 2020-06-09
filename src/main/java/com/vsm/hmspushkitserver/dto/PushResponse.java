package com.vsm.hmspushkitserver.dto;

import com.vsm.hmspushkitserver.dto.auth.AuthResponse;
import lombok.Data;


public @Data class PushResponse {
    private String description;
    private int id;
    private AuthResponse tokenResponse;


}
