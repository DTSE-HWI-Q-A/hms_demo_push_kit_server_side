package com.vsm.hmspushkitserver.dto.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class Notification {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;

    public Notification(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
