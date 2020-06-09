package com.vsm.hmspushkitserver.dto;

import lombok.Data;

import java.util.List;

@Data
public class PushRequest {
    private String tittle;
    private String message;
    private List <String> usersTokens;
}

