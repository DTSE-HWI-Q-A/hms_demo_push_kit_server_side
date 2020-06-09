package com.vsm.hmspushkitserver.repository;

import com.google.gson.JsonObject;
import com.vsm.hmspushkitserver.dto.auth.AuthRequest;
import com.vsm.hmspushkitserver.dto.auth.AuthResponse;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface RepositoryInterface {

    @POST("token")
    Call<AuthResponse> getAccessToken(@Header("Content-Type") String content_type,@Body RequestBody params);
}
