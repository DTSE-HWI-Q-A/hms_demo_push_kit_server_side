package com.vsm.hmspushkitserver.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vsm.hmspushkitserver.configuration.APIConfiguration;
import com.vsm.hmspushkitserver.dto.PushRequest;
import com.vsm.hmspushkitserver.dto.PushResponse;
import com.vsm.hmspushkitserver.dto.messages.*;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class PushService implements APIConfiguration {
    public PushResponse sendNotification(PushRequest pushReques) {
        PushResponse finalResponse = new PushResponse();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder().build();
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(getMessage(pushReques));
            JSONObject jsonObj = new JSONObject(json);

            RequestBody body = RequestBody.create(mediaType, jsonObj.toString());
            Request request = new Request.Builder()
                    .url(API_SEND_NOTIFICATION)
                    .method("POST", body)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("Authorization", pushReques.getToken())
                    .build();
            Response response = client.newCall(request).execute();
            finalResponse.setId(1);
            finalResponse.setDescription("Message sent");

        }catch (Exception e){
finalResponse.setDescription(e.getMessage());
finalResponse.setId(-1);
return finalResponse;
        }
        return finalResponse;
    }

    private MessagesRequest getMessage(PushRequest pushReques){
        Notification notification = new Notification(pushReques.getTittle(),pushReques.getMessage());

        ClickAction clickAction = new ClickAction(1,"#Intent;compo=com.rvr/.Activity;S.W=U;end");
        Notification_ notification_= new Notification_(pushReques.getTittle(),pushReques.getMessage(),clickAction);

        Android android = new Android(notification_);

        Message message = new Message(notification,android,pushReques.getUsersTokens());

        MessagesRequest messagesRequest = new MessagesRequest();
        messagesRequest.setValidateOnly(false);
        messagesRequest.setMessage(message);
        return messagesRequest;
    }


}
