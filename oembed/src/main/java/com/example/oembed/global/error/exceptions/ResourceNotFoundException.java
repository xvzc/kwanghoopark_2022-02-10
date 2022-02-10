package com.example.oembed.global.error.exceptions;

import com.example.oembed.global.error.ErrorCode;

public class ResourceNotFoundException  extends RuntimeException {
    public ErrorCode errorCode;

    public ResourceNotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}