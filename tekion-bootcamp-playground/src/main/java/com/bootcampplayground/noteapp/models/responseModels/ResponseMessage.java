package com.bootcampplayground.noteapp.models.responseModels;

import lombok.Data;

@Data
public class ResponseMessage {
    private boolean success;
    private String message;

    public ResponseMessage() {
    }

    public ResponseMessage(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
