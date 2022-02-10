package com.example.oembed.global.error.exceptions;

import com.example.oembed.global.error.ErrorCode;

public class InvalidInputException extends RuntimeException {
    public ErrorCode errorCode;

    public InvalidInputException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
