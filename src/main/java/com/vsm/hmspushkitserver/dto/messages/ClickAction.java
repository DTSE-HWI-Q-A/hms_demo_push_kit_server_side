package com.vsm.hmspushkitserver.dto.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class ClickAction {
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("intent")
    @Expose
    private String intent;


    public ClickAction(Integer type, String intent) {
        this.type = type;
        this.intent = intent;
    }
}
