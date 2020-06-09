package com.vsm.hmspushkitserver.dto.auth;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class AuthResponse {
    @Expose
    private String access_token;
    @Expose
    private String expires_in;
    @Expose
    private String token_type;


}
