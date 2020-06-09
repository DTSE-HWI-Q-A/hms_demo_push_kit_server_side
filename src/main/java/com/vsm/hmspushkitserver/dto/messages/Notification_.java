package com.vsm.hmspushkitserver.dto.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class Notification_ {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("click_action")
    @Expose
    private ClickAction clickAction;

    public Notification_(String title, String body, ClickAction clickAction) {
        this.title = title;
        this.body = body;
        this.clickAction = clickAction;
    }
}
