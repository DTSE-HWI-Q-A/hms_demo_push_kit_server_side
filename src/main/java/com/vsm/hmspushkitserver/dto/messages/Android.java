package com.vsm.hmspushkitserver.dto.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class Android {
    @SerializedName("notification")
    @Expose
    private Notification_ notification;

    public Android(Notification_ notification) {
        this.notification = notification;
    }
}
