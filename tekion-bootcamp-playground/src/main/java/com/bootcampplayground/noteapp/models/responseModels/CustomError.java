package com.bootcampplayground.noteapp.models.responseModels;

import lombok.Data;

public class CustomError extends Exception {
    private int status;

    public CustomError(int status, String message, Throwable err) {
        super(message, err);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
