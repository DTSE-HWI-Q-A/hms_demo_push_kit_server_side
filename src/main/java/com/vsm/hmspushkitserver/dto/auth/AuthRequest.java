package com.vsm.hmspushkitserver.dto.auth;

import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class AuthRequest {
    @Expose
    @Getter
    @Setter
    private String grant_type;
    @Expose
    @Getter
    @Setter
    private String client_secret;
    @Expose
    @Getter
    @Setter
    private String client_id;
}
