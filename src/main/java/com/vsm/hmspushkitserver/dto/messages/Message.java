package com.vsm.hmspushkitserver.dto.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

public @Data
class Message {

    @SerializedName("notification")
    @Expose
    private Notification notification;
    @SerializedName("android")
    @Expose
    private Android android;
    @SerializedName("token")
    @Expose
    private List<String> token = null;

    public Message(Notification notification, Android android, List<String> token) {
        this.notification = notification;
        this.android = android;
        this.token = token;
    }
}
