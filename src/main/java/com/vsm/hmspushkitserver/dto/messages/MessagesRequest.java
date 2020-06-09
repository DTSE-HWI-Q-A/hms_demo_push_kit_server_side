package com.vsm.hmspushkitserver.dto.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class MessagesRequest {
    @SerializedName("validate_only")
    @Expose
    private Boolean validateOnly;
    @SerializedName("message")
    @Expose
    private Message message;
}
