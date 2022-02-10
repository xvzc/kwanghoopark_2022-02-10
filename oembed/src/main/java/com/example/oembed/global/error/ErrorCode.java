package com.example.oembed.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // GLOBAL
    INTERNAL_SERVER_ERROR(500, "G-000", "Internal server error"),
    INVALID_INPUT_VALUE(400, "G-001", " Invalid input value"),

    // Preview
    INVALID_URL_FORM(400, "P-000", "Malformed url."),
    UNSUPPORTED_PLATFORM(400, "P-001", "Unsupported platform."),
    PREVIEW_NOT_FOUND(404, "P-002", "Couldn't find the preview for the requested resource."),
    ;

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}