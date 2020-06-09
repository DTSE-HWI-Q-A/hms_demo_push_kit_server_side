package com.vsm.hmspushkitserver.dto.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;


public @Data
class AuthRequest {

    @SerializedName("grant_type")
    @Expose
    private String grant_type;
    @SerializedName("client_secret")
    @Expose
    private String client_secret;
    @SerializedName("client_id")
    @Expose
    private String client_id;

    public AuthRequest(String grant_type, String client_secret, String client_id) {
        this.grant_type = grant_type;
        this.client_secret = client_secret;
        this.client_id = client_id;
    }
}
