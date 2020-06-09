package com.vsm.hmspushkitserver.service;

import com.google.gson.Gson;
import com.vsm.hmspushkitserver.configuration.APIConfiguration;
import com.vsm.hmspushkitserver.dto.PushResponse;
import com.vsm.hmspushkitserver.dto.auth.AuthResponse;
import okhttp3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TokenService implements APIConfiguration {
    private static final Logger logger = LogManager.getLogger(TokenService.class.getSimpleName());

    public PushResponse getTransactionToken(){
        PushResponse response = new PushResponse();

        AuthResponse authResponse = null;
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_secret=insert_your_app_secret&client_id=insert_your_client_id");
            Request request2 = new Request.Builder()
                    .url("https://oauth-login.cloud.huawei.com/oauth2/v3/token")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build();
            Response response2 = client.newCall(request2).execute();
            logger.info("Method: getTransactionToken(): " + response2.body().toString());
            Gson gson = new Gson();
            authResponse = gson.fromJson(response2.body().string(), AuthResponse.class);
            if (authResponse!=null)
            {
                logger.info("Method: getTransactionToken(): " + authResponse.toString());
                response.setId(1);
                response.setDescription("OK");
                response.setTokenResponse(authResponse);
            }else
                {
                response.setId(-1);
                response.setDescription("An error occurred");
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.setId(-1);
            response.setDescription(e.getMessage());
            logger.error("Method: getTransactionToken(): " + e.getMessage());
            return response;
        } catch (JSONException e) {
            e.printStackTrace();
            response.setId(-1);
            response.setDescription(e.getMessage());
        }
        return response;
    }

}
